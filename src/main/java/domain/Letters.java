package domain;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Letters {
    private static final String VALIDATE_ALPHABET = "영단어만 가능합니다.";
    private static final String ALPHABET_REGEX = "^[a-zA-Z]*$";
    private static final String VALIDATE_WORDS_SIZE = "word의 크기는 5글자여야만 합니다.";
    private static final int MAXIMUM_WORD_SIZE = 5;
    private final List<Letter> list;

    public Letter getLetter(int index) {
        return list.get(index);
    }

    public int getSize() {
        return list.size();
    }

    public Map<Letter, Long> mapToCount() {
        return list.stream().collect(Collectors.groupingBy(
                Function.identity(), Collectors.counting()
        ));
    }

    private Letters(List<Letter> list) {
        this.list = list;
    }

    public static Letters of(String word) {
        validateLength(word);
        validateAlphabet(word);
        return new Letters(
                word.chars()
                        .mapToObj(letter -> new Letter((char) letter))
                        .collect(Collectors.toList())
        );
    }

    private static void validateAlphabet(String word) {
        if (!Pattern.matches(ALPHABET_REGEX, word)) {
            throw new IllegalArgumentException(VALIDATE_ALPHABET);
        }
    }

    private static void validateLength(String word) {
        if (word.length() > MAXIMUM_WORD_SIZE) {
            throw new IllegalArgumentException(VALIDATE_WORDS_SIZE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Letters letters = (Letters) o;
        return Objects.equals(list, letters.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }
}
