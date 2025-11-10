use std::{env, net::SocketAddr, str::FromStr};

use http_implementation::{connection::tcp::TcpServerConnection, http::server::Server};

fn main() {
    let args: Vec<String> = env::args().collect();

    // put on there a way to insert the quantity of sockets you wanna
    // if theres none defined ip set it to default with default port
    // like cargo run --release -- threads[4] --ip[127.0.0.1] --port[9090] like this

    let socket = &args[1];

    let tcp_server_connection = TcpServerConnection::new(
        SocketAddr::from_str(socket).expect("Specified socket does not exist"),
    )
    .expect("Unable to initialize connection. Server shutdown");

    let http_server = Server::new(tcp_server_connection);
    http_server.run();
}
