package wordle;

import java.util.ArrayList;
import java.util.List;

public class Words {
    private static final int MAX_LENGTH = 5;
    private final List<Word> words;

    public Words(String text) {
        validateLength(text);

        words = new ArrayList<>();
        for (String ch: text.split("")) {
            words.add(new Word(ch));
        }
    }

    private void validateLength(String text) {
        if (text.length() != MAX_LENGTH) {
            throw new IllegalArgumentException("text length cannot be over than MAX_LENGTH");
        }
    }
}
