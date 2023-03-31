package wordle;

import java.util.ArrayList;
import java.util.List;

public class Words {
    private static final int MAX_LENGTH = 5;
    private final List<Word> words;

    public Words(String text) {
        validateLength(text);

        words = new ArrayList<>();
        for (char ch: text.toCharArray()) {
            words.add(new Word(ch));
        }
    }

    public String castWordsToString() {
        StringBuilder wordsToString = new StringBuilder();

        for (Word word : words) {
            wordsToString.append(word.getValue());
        }

        return wordsToString.toString();
    }

    private void validateLength(String text) {
        if (text.length() != MAX_LENGTH) {
            throw new IllegalArgumentException("text length cannot be over than MAX_LENGTH");
        }
    }
}
