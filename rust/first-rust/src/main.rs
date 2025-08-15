use axum::{
    http::StatusCode,
    routing::{get, post},
    Json, Router,
};
use serde::{Deserialize, Serialize};
use std::net::SocketAddr;
use uuid::Uuid;

#[tokio::main]
async fn main() {
    let app = app();
    let addr = SocketAddr::from(([127, 0, 0, 1], 3000));
    println!("listening on {}", addr);
    let listener = tokio::net::TcpListener::bind(addr).await.unwrap();
    axum::serve(listener, app).await.unwrap();
}

fn app() -> Router {
    Router::new()
        .route("/", get(root))
        .route("/users", post(create_user))
}

async fn root() -> &'static str {
    "Hello, World!"
}

#[derive(Serialize, Debug, PartialEq)]
struct User {
    id: Uuid,
    name: String,
}

#[derive(Deserialize)]
struct CreateUserPayload {
    name:String,
}


async fn create_user(
    Json(payload): Json<CreateUserPayload>,
) -> (StatusCode, Json<User>) {
    let user = User {
        id: Uuid::new_v4(),
        name: payload.name,
    };

    (StatusCode::CREATED, Json(user))
}
