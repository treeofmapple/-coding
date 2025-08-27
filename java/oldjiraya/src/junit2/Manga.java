package junit2;

import java.util.Objects;

public record Manga(String name, int episodes) {

    public Manga {
        Objects.requireNonNull(name);
    }
}
