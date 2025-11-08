use std::{env, net::SocketAddr, str::FromStr};

use http_implementation::{connection::tcp::TcpServerConnection, http::server::Server};

fn main() {
    let args: Vec<String> = env::args().collect();

    let socket = &args[1];

    // Create connection for the server
    let tcp_server_connection = TcpServerConnection::new(
        SocketAddr::from_str(socket).expect("Specified socket does not exist"),
    )
    .expect("Unable to initialize connection. Server shutdown");
    // Init Http server
    let http_server = Server::new(tcp_server_connection);
    http_server.run();
}
