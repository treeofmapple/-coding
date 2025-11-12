use std::{env, net::{IpAddr, SocketAddr}, str::FromStr};
use http_implementation::{connection::tcp::TcpServerConnection, http::server::Server};

use crate::consts::{BUFFER_SIZE_DEFAULT, THREAD_QTD};

mod consts;

fn main() {
    let args: Vec<String> = env::args().collect();

    if args.len() < 3 {
        eprintln!("Usage: <program> <ip> <port>");
        std::process::exit(1);
    }

    let ip_arg = &args[1];
    let port_arg = &args[2];

    let ip_str = parse_bracketed_value(ip_arg, "ip")
        .expect("Invalid IP argument format. Expected ip[<value>]");
    let port_str = parse_bracketed_value(port_arg, "port")
        .expect("Invalid port argument format. Expected port[<value>]");

    let ip_addr = IpAddr::from_str(&ip_str).expect("Invalid IP address");
    let port_num: u16 = port_str.parse().expect("Invalid port number");

    let threads = THREAD_QTD;

    let socket = SocketAddr::new(ip_addr, port_num);
    let tcp_server_connection = TcpServerConnection::new_threads(socket, threads)
        .expect("Unable to initialize connection. Server Shutdown");

    TcpServerConnection::set_buffer_size(BUFFER_SIZE_DEFAULT);

    let http_server = Server::new(tcp_server_connection);
    http_server.run();
    eprintln!("Running Server on IP: {}:{}", ip_str, port_str);
}

fn parse_bracketed_value(arg: &str, prefix: &str) -> Option<String> {
    let expected_prefix = format!("{}[", prefix);
    if arg.starts_with(&expected_prefix) && arg.ends_with(']') {
        Some(arg[expected_prefix.len()..arg.len() - 1].to_string())
    } else {
        None
    }
}
