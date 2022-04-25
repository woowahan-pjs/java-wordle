package model;

public class Word {

    private final Characters characters;

    Word(String value) {
        this.characters = new Characters(value);
    }

    public static Word create(String value) {
        return new Word(value);
    }

}
