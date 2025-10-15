enum IpAddrKind {
    V4,
    V6,
}

enum IpAddrs {
    V4(String),
    V6(String),
}

enum IpAddrss {
    V4(u8, u8, u8, u8),
    V6(String),
}

enum Message {
    Quit,
    Move { x: i32, y: i32 },
    Write(String),
    ChangeColor(i32, i32, i32),
}

struct IpAddr<'a> {
    kind: IpAddrKind,
    address: &'a str,
}

static HOME: IpAddr = IpAddr {
    kind: IpAddrKind::V4,
    address: "127.0.0.1",
};

static LOOPBACK: IpAddr = IpAddr {
    kind: IpAddrKind::V6,
    address: "::1",
};

impl Message {
    fn call(&self) {}
}

fn route(ip_kind: IpAddrKind) {}

fn main() {
    let _four = IpAddrKind::V4;
    let _six = IpAddrKind::V6;

    route(IpAddrKind::V4);
    route(IpAddrKind::V6);

    let _home = IpAddrs::V4(String::from("127.0.0.1"));
    let _home2 = IpAddrss::V4(127, 0, 0, 1);
    let _loopback = IpAddrs::V6(String::from("::1"));

    let m = Message::Write(String::from("hello"));
    m.call();
}
