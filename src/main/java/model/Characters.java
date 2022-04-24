package model;

import java.util.ArrayList;
import java.util.List;

public class Characters {

    private static final int WORD_LENGTH = 5;

    private List<Character> characterList;

    public Characters(String inputString) {
        validate(inputString);
        List<Character> characterList = new ArrayList<>();
        String[] split = inputString.split("");
        for (int i = 0; i < WORD_LENGTH; i++) {
            characterList.add(new Character(split[i], i));
        }
        this.characterList = characterList;
    }

    public List<Character> getCharacters() {
        return characterList;
    }

    private void validate(String value) {
        if (value.length() != WORD_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
