package model;

public class Word {

    private String value;

    Word(String value) {
        this.value = value;
    }

    public static Word create(String value) {
        return new Word(value);
    }

    public int length() {
        return value.length();
    }
}
