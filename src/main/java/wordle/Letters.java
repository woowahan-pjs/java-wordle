package wordle;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Letters {

    private final List<Letter> letters;

    public Letters(String word) {
        char[] wordArr = word.toCharArray();

        this.letters = new ArrayList<>();
        for (int i = 0; i < wordArr.length; i++) {
            letters.add(new Letter(i, wordArr[i]));
        }
    }

    public Letters(List<Letter> letters) {
        this.letters = letters;
    }

    public List<Letter> getLetters() {
        return letters;
    }

    public boolean lessThan(int size) {
        return letters.size() < size;
    }

    public boolean higherThan(int size) {
        return letters.size() > size;
    }

    public String combine() {
        return letters.stream()
            .map(letter -> String.valueOf(letter.getValue()))
            .collect(Collectors.joining(""));
    }

    public boolean contains(Letter letter) {
        return letters.contains(letter);
    }

    public Letters findSamePositionAndValueLetters(Letters other) {
        List<Letter> filteredLetters = letters.stream()
                .filter(other::contains)
                .toList();

        return new Letters(filteredLetters);
    }

    public Letters findSameValueLetters(Letters other) {
        List<Letter> filteredLetters = letters.stream()
                .filter(letter -> !other.contains(letter))
                .filter(other::isOnlySameValue)
                .toList();

        return new Letters(filteredLetters);
    }

    private boolean isOnlySameValue(Letter other) {
        return letters.stream()
                .anyMatch(letter -> (Objects.equals(letter.getValue(), other.getValue())) && letter.getPosition() != other.getPosition());
    }

    public Letters findNoneMatchingLetters(Letters other) {
        Set<Character> otherValues = other.extractValues();
        List<Letter> filteredLetters = letters.stream()
                .filter(letter -> !otherValues.contains(letter.getValue()))
                .toList();

        return new Letters(filteredLetters);
    }

    private Set<Character> extractValues() {
        return letters.stream()
                .map(Letter::getValue)
                .collect(Collectors.toSet());
    }

    public int size() {
        return letters.size();
    }
}
