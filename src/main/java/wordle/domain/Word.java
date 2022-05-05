package wordle.domain;

import org.junit.platform.commons.util.StringUtils;

public class Word {
    private static final int WORD_LENGTH = 5;
    private final String word;

    public Word(String word) {
        if (isNotValid(word)) {
            throw new IllegalArgumentException("유효하지 않은 단어 문자열 입니다.");
        }

        this.word = word;
    }

    private boolean isNotValid(String word) {
        return StringUtils.isBlank(word) || word.length() != WORD_LENGTH;
    }

    public String getWord() {
        return word;
    }
}
