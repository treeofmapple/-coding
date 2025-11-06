use std::{
    io::{Read, Write},
    net::{SocketAddr, TcpListener},
};

use crate::thread::pool::ThreadPool;

mod tests;

pub struct TcpServerConnection {
    listener: TcpListener,
    pool: ThreadPool,
}

impl TcpServerConnection {
    pub fn new(socket: SocketAddr) -> io::Result<TcpServerConnection> {
        let listener = TcpListener::bind(socket)?;
        Ok(TcpServerConnection {
            listener,
            pool: ThreadPool::new(4), // make this an option
        })
    }
}

impl TcpServerConnection {
    fn handle_incoming_connection<
        Callback: Fn(&[u8]) -> Result<Vec<u8>, ServerError> + Send + Sync,
        Stream: Read + Write,
    >(
        request_handler_callback: Callback,
        stream: &mut Stream,
    ) {
        let mut input_buffer: [u8; 1024] = [0; 1024];
        match stream.read(&mut input_buffer) {
            Ok(_) => {
                match (request_handler_callback)(&input_buffer)
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
                        Self::handle_incoming_connection(&request_handler_callback)
                    });
                }
                Err(e) => println!("Error when getting client: {:?}", e),
            }
        }
    }
}
