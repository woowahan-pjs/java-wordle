package wordle.model;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Letters implements Iterable<Letter> {

    private final List<Letter> letters;

    public Letters(String word) {
        String lowerCase = word.toLowerCase();
        this.letters = IntStream.range(0, lowerCase.length())
                .mapToObj(i -> new Letter(i, lowerCase.charAt(i)))
                .toList();
    }

    public Letters(List<Letter> letters) {
        this.letters = letters;
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

    @Override
    public Iterator<Letter> iterator() {
        return letters.iterator();
    }

    public Stream<Letter> stream() {
        return letters.stream();
    }
}
