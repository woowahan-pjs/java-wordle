package wordle.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Letters {

    private final List<Letter> letters;

    public Letters(String word) {
        String lowerCase = word.toLowerCase();
        char[] wordArr = lowerCase.toCharArray();

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
            .anyMatch(letter -> letter.isOnlyEqualToValue(other));
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
