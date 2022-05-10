package domain;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Letters {
    private final List<Letter> list;

    public static Letters of(String word) {
        validateLength(word);
        validateAlphabet(word);
        return new Letters(
                word.chars()
                        .mapToObj(letter -> new Letter((char) letter))
                        .collect(Collectors.toList())
        );
    }

    private Letters(List<Letter> list) {
        this.list = list;
    }

    public List<Letter> getList() {
        return list;
    }

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

    private static void validateAlphabet(String word) {
        if (!Pattern.matches("^[a-zA-Z]*$", word)) {
            throw new IllegalArgumentException("영단어만 가능합니다.");
        }
    }

    private static void validateLength(String word) {
        if (word.length() > 5) {
            throw new IllegalArgumentException("word의 크기는 5글자여야만 합니다.");
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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Letters = ");
        for (Letter letter : list){
            stringBuilder.append(letter.toString());
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
