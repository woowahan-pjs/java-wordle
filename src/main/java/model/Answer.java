package model;

public class Answer {

    private String value;

    Answer(String value) {
        this.value = value;
    }

    public static Answer create(String value) {
        return new Answer(value);
    }

    public int length() {
        return value.length();
    }
}
