package domain;

import java.util.Objects;
import java.util.regex.Pattern;

public class Tile {

    char value;

    public Tile(char value) {
        if (!Pattern.matches("^[a-zA-Z]*$", String.valueOf(value))) {
            throw new IllegalArgumentException(value + "는 알파벳이 아님");
        }

        this.value = Character.toLowerCase(value);
    }

    public char getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tile tile = (Tile) o;
        return getValue() == tile.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
