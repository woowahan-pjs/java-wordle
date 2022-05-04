package domain;

import java.util.regex.Pattern;

public class Tile {

    char value;

    public Tile(char value) {
        if (!Pattern.matches("^[a-zA-Z]*$", String.valueOf(value))) {
            throw new IllegalArgumentException(value + "는 알파벳이 아님");
        }

        this.value = value;
    }

    public char getValue() {
        return value;
    }
}
