use std::{
    io::{self, Read, Write},
    net::{SocketAddr, TcpListener}, sync::atomic::{AtomicU32, Ordering},
};

use num_cpus;

use crate::{
    http::server::{Connection, ServerError},
    thread::pool::ThreadPool,
};

#[cfg(test)]
mod tests;

pub struct TcpServerConnection {
    listener: TcpListener,
    pool: ThreadPool,
}

static BUFFER_SIZE: AtomicU32 = AtomicU32::new(1024);

impl TcpServerConnection {
    pub fn new(socket: SocketAddr) -> io::Result<TcpServerConnection> {
        let listener = TcpListener::bind(socket)?;
        Ok(TcpServerConnection {
            listener,
            pool: ThreadPool::new(4),
        })
    }

    pub fn new_threads(socket: SocketAddr, qtd_threads: i32) -> io::Result<TcpServerConnection> {
        let listener = TcpListener::bind(socket)?;

        let max_threads = num_cpus::get() as i32;
        let threads_to_use = if qtd_threads <= 0 {
            1
        } else if qtd_threads > max_threads {
            max_threads
        } else {
            qtd_threads
        };

        Ok(TcpServerConnection {
            listener,
            pool: ThreadPool::new(threads_to_use as usize),
        })
    }

    pub fn set_buffer_size(value: u32) {
        BUFFER_SIZE.store(value, Ordering::Relaxed);
    }

    fn handle_incoming_connection<
        Callback: Fn(&[u8]) -> Result<Vec<u8>, ServerError> + Send + Sync,
        Stream: Read + Write,
    >(
        request_handler: Callback,
        stream: &mut Stream,
    ) {

        let buffer_size = BUFFER_SIZE.load(Ordering::Relaxed);
        let mut input_buffer = vec![0u8; buffer_size as usize];
        match stream.read(&mut input_buffer) {
            Ok(_) => {
                match (request_handler)(&input_buffer)
                    .map(|message| stream.write(&message))
                    .map(|_| stream.flush())
                {
                    Ok(_) => println!("Request was succesfully handled"),
                    Err(e) => println!("Error when handling request: {:?}", e),
                }
            }
            Err(error) => {
                println!("{:?}", error);
            }
        }
    }
}

impl Connection for TcpServerConnection {
    fn listen<T: 'static + Copy + Fn(&[u8]) -> Result<Vec<u8>, ServerError> + Send + Sync>(
        &self,
        request_handler_callback: T,
    ) {
        for connection in self.listener.incoming() {
            match connection {
                Ok(mut socket) => {
                    self.pool.execute(move || {
                        Self::handle_incoming_connection(request_handler_callback, &mut socket)
                    });
                }
                Err(e) => println!("Error when getting client: {:?}", e),
            }
        }
    }
}
