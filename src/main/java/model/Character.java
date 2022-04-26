package model;

public class Character implements Comparable<Character> {

    private static final String INPUT_RANGE = "[a-zA-Z]";
    private static final int POSITION_INIT = 0;

    private int position;
    private String value;

    public Character(String value) {
        this(value, POSITION_INIT);
    }

    public Character(String value, int position) {
        validate(value);
        this.value = convertToLowercase(value);
        this.position = position;
    }

    private void validate(String value) {
        if (!value.matches(INPUT_RANGE)) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int compareTo(Character other) {
        return value.compareTo(other.value);
    }

    private String convertToLowercase(String value) {
        return value.toLowerCase();
    }

    public int getPosition() {
        return this.position;
    }
}
