package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Word {

    private final List<Letter> letters;

    private Word(List<Letter> letters) {
        this.letters = letters;
    }

    public static Word from(String input) {
        validate(input);
        char[] chars = input.toCharArray();
        List<Letter> letterList = new ArrayList<>();
        for (char aChar : chars) {
            letterList.add(new Letter(aChar));
        }
        return new Word(letterList);
    }

    private static void validate(String input) {
        validateNullAndEmpty(input);
        validateLength(input);
    }

    private static void validateNullAndEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("단어는 빈 값일 수 없습니다.");
        }
    }

    private static void validateLength(String input) {
        if (input.length() != 5) {
            throw new IllegalArgumentException("단어는 5글자여야 합니다. | input :" + input);
        }
    }

    public List<Letter> getLetters() {
        return letters;
    }

    public boolean contains(Letter letter) {
        return letters.contains(letter);
    }

    public Letter get(int position) {
        return letters.get(position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Word word = (Word) o;

        return Objects.equals(letters, word.letters);
    }

    @Override
    public int hashCode() {
        return letters != null ? letters.hashCode() : 0;
    }

}
