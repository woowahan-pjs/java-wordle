package domain;

import java.util.Objects;
import java.util.regex.Pattern;

public class Word {
    public static final int WORD_LENGTH = 5;
    private static final Pattern pattern = Pattern.compile("^[a-zA-Z]*");

    private final String word;

    public Word(String word) {
        if (this.isNotMatchWord(word)) {
            throw new IllegalArgumentException(word + "는 5글자의 알파벳이 아닙니다.");
        }

        this.word = word;
    }

    private boolean isNotMatchWord(String word){
        return word.length() != WORD_LENGTH || !pattern.matcher(word).matches();
    }

    public String getWord() {
        return word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        return Objects.equals(word, word1.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }

    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                '}';
    }
}
