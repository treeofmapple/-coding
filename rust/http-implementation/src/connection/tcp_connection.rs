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
                {
                    Ok(_) => unimplemented!(),
                    Err(e) => unimplemented!(),
                }
            }
            Err(error) => {
                println!("{:?}", error);
            }
        }
    }
}

impl Connection for TcpServerConnection {}
