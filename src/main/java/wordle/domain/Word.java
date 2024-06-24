package wordle.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import wordle.exception.InvalidWordException;

public class Word implements Iterable<Letter> {

    public static final int WORD_LENGTH = 5;
    private final List<Letter> letters;

    public Word(final String input) {
        if (input.length() != WORD_LENGTH) {
            throw new InvalidWordException();
        }

        this.letters = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            final Letter letter = new Letter(input.charAt(i), i);
            this.letters.add(letter);
        }
    }

    public Results compare(final Word inputWord) {
        final WordComparator wordComparator = new WordComparator(this.letters);
        return wordComparator.compare(inputWord);
    }

    static class WordComparator {

        private final List<Letter> pendingLetters;
        private final Results results;

        public WordComparator(final List<Letter> letters) {
            this.pendingLetters = new ArrayList<>(letters);
            this.results = new Results();
        }

        public Results compare(final Word inputWord) {
            for (final Letter letter : inputWord) {
                process(letter, letter::equals, Tile.GREEN);
            }

            for (final Letter letter : inputWord) {
                process(letter, letter::isSameAlphabet, Tile.YELLOW);
            }

            for (final Letter letter : inputWord) {
                fillEmptyToGray(letter);
            }

            return results;
        }

        private void process(final Letter targetLetter, final Predicate<Letter> predicate, final Tile tile) {
            if (results.isCheckedPosition(targetLetter)) {
                return;
            }

            pendingLetters.stream()
                    .filter(predicate)
                    .findFirst()
                    .ifPresent(letter -> {
                        pendingLetters.remove(letter);
                        results.add(new Result(tile, targetLetter));
                    });
        }

        private void fillEmptyToGray(final Letter targetLetter) {
            if (results.isCheckedPosition(targetLetter)) {
                return;
            }

            pendingLetters.forEach(
                    letter -> results.add(new Result(Tile.GRAY, targetLetter)));
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Word word = (Word) o;
        return Objects.equals(letters, word.letters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(letters);
    }

    @Override
    public Iterator<Letter> iterator() {
        return this.letters.iterator();
    }
}
