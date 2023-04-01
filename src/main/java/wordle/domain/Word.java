package wordle.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Word {
    private static final int MAX_LENGTH = 5;
    private final List<Letter> letters;

    public Word(String text) {
        validateLength(text);

        letters = new ArrayList<>();
        for (char ch : text.toCharArray()) {
            letters.add(new Letter(ch));
        }
    }

    public String castWordsToString() {
        StringBuilder wordsToString = new StringBuilder();

        for (Letter letter : letters) {
            wordsToString.append(letter.getValue());
        }

        return wordsToString.toString();
    }

    private void validateLength(String text) {
        if (text.length() != MAX_LENGTH) {
            throw new IllegalArgumentException("text length cannot be over than MAX_LENGTH");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return Objects.equals(letters, word.letters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(letters);
    }
}
