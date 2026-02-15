package domain;

import java.util.Objects;
import java.util.regex.Pattern;

public class Tile {

    private final char value;
    private final Position position;

    public Tile(char value, int position) {
        if (!Pattern.matches("^[a-zA-Z]*$", String.valueOf(value))) {
            throw new IllegalArgumentException(value + "는 알파벳이 아님");
        }

        this.value = Character.toLowerCase(value);
        this.position = new Position(position);
    }

    public MatchStatus matches(Tile tile) {
        if (this.value != tile.value) {
            return MatchStatus.GREY;
        }
        if (this.position.equals(tile.position)) {
            return MatchStatus.GREEN;
        }

        return MatchStatus.YELLOW;
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

    @Override
    public String toString() {
        return "Tile{" +
                "value=" + value +
                '}';
    }
}
