#include <SFML/Graphics.hpp>
#include <vector>
#include <cmath>
#include <cstdlib>
#include <algorithm>

int WIDTH = 800;
int HEIGHT = 800;
const int num_stars = 100;

struct Star {
    float x, y, z, pz;

    Star(int width, int height) {
        x = (std::rand() % (2 * width)) - width;
        y = (std::rand() % (2 * height)) - height;
        z = std::rand() % width;
        pz = z;
    }

    void reset(int width, int height) {
        x = (std::rand() % (2 * width)) - width;
        y = (std::rand() % (2 * height)) - height;
        z = std::rand() % width;
        pz = z;
    }

    void update(float speed, int width, int height) {
        z -= speed;
        if (z < 1) {
            reset(width, height);
        }
    }

    void show(sf::RenderWindow & window, int width, int height) {
        float sx = (x / z) * width / 2 + width / 2;
        float sy = (y / z) * height / 2 + height / 2;
        float r = (1 - z / width) * 8;

        sf::CircleShape starShape(r);
        starShape.setPosition(sx, sy);
        starShape.setFillColor(sf::Color::White);
        window.draw(starShape);

        float px = (x / pz) * width / 2 + width / 2;
        float py = (y / pz) * height / 2 + height / 2;

        sf::Vertex line[] = {
            sf::Vertex(sf::Vector2f(px, py), sf::Color::White),
            sf::Vertex(sf::Vector2f(sx, sy), sf::Color::White)
        };
        window.draw(line, 2, sf::Lines);

        pz = z;
    }
};

int main() {
    sf::RenderWindow window(sf::VideoMode(WIDTH, HEIGHT), "Starfield Simulation", sf::Style::Resize);
    window.setFramerateLimit(60);

    std::vector<Star> stars;
    for (int i = 0; i < num_stars; ++i) {
        stars.emplace_back(WIDTH, HEIGHT);
    }

    while (window.isOpen()) {
        sf::Event event;
        while (window.pollEvent(event)) {
            if (event.type == sf::Event::Closed)
                window.close();
            
            if (event.type == sf::Event::Resized) {
                WIDTH = event.size.width;
                HEIGHT = event.size.height;
                window.setView(sf::View(sf::FloatRect(0, 0, WIDTH, HEIGHT)));

                for (auto& star : stars) {
                    star.reset(WIDTH, HEIGHT);
                }
            }
        }

        float speed = 5.0f;

        window.clear(sf::Color::Black);
        for (auto& star : stars) {
            star.update(speed, WIDTH, HEIGHT);
            star.show(window, WIDTH, HEIGHT);
        }
        window.display();
    }

    return 0;
}
