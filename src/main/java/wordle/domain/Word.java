package wordle.domain;

import wordle.exception.WordException;

import java.util.ArrayList;
import java.util.List;

public class Word {

    private static final int WORD_LENGTH = 5;

    private final List<Letter> letters;

    public Word(final String input) {
        if (input.length() != WORD_LENGTH) {
            throw new WordException("단어가 5글자여야 합니다.");
        }

        this.letters = new ArrayList<>();
        for (char c : input.toCharArray()) {
            this.letters.add(new Letter(c));
        }
    }

    public String getValue() {
        StringBuilder builder = new StringBuilder();
        for (Letter letter : letters) {
            builder.append(letter.getAlphabet());
        }
        return builder.toString();
    }
}
