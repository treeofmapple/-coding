#include <SFML/Graphics.hpp>
#include <vector>
#include <cmath>
#include <cstdlib>

const int WIDTH = 800;
const int HEIGHT = 800;
const int num_stars = 100;

struct star() {
    float x, y, z, pz;

    Star() {
        x = (std::rand() % (2 * WIDTH)) - WIDTH;
        y = (std::rand() % (2 * HEIGHT)) - HEIGHT;
        z = std::rand() % WIDTH;
        pz = z;
    }

    void update(float speed) {
        z -= speed;
        if (z < 1) {
            z = WIDTH;
            x = (std::rand() % (2 * WIDTH)) - WIDTH;
            y = (std::rand() % (2 * HEIGHT)) - HEIGHT;
            pz = z;
        }
    }

    void show(sf::RenderWindow &window) {
        float sx = (x / z) * WIDTH / 2 + WIDTH / 2;
        float sy = (y / z) * HEIGHT / 2 + HEIGHT / 2;
        float r = (1 - z / WIDTH) * 8;

        sf::CircleShape starShape(r);
        starShape.setPosition(sx, sy);
        starShape.setFillColor(sf::Color::White);
        window.draw(starShape);

        float px = (x / pz) * WIDTH / 2 + WIDTH / 2;
        float py = (y / pz) * HEIGHT / 2 + HEIGHT / 2;

        sf::Vertex line[] = {
            sf::Vertex(sf::Vector2f(px, py), sf::Color::White),
            sf::Vertex(sf::Vector2f(sx, sy), sf::Color::White)
        };
        window.draw(line, 2, sf::Lines);

        pz = z;
    }

};

int main() {
    sf::RenderWindow window(sf::VideoMode(WIDTH, HEIGHT), "Starfield Simulation");
    window.setFramerateLimit(60);

    std::vector<Star> stars(NUM_STARS);

    while (window.isOpen()) {
        sf::Event event;
        while (window.pollEvent(event)) {
            if (event.type == sf::Event::Closed)
                window.close();
        }

        float speed = 5.0f;

        window.clear(sf::Color::Black);
        for (auto& star : stars) {
            star.update(speed);
            star.show(window);
        }
        window.display();
    }

    return 0;
}
