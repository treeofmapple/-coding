use dioxus::prelude::*;

fn main() {
    dioxus_tui::launch(App);
}

#[allow(non_snake_case)]
fn App() -> Element {
    let mut count = use_signal(|| 0);

    rsx! {
        div {
            width: "100%",
            height: "100%",
            flex_direction: "column",
            align_items: "center",
            justify_content: "center",
            gap: "1rem",

            div {
                "High-Five Counter: {count}"
            }

            div {
                flex_direction: "row",
                gap: "2rem",

                button {
                    onclick: move |_| count += 1,
                    "Up high! (+)"
                }

                button {
                    onclick: move |_| count -= 1,
                    "Down low! (-)"
                }
            }
        }
    }
}
