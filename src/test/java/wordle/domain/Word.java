package wordle.domain;

import java.util.ArrayList;
import java.util.List;
import wordle.exception.WordInputNotValidException;

public class Word {

    public static final int WORD_LENGTH = 5;
    private List<Letter> letters;

    public Word(String input) {
        if (input.length() != WORD_LENGTH) {
            throw new WordInputNotValidException();
        }

        this.letters = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            Letter letter = new Letter(input.charAt(i), i);
            this.letters.add(letter);
        }
    }
}
