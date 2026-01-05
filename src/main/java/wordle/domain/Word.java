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

    public Word(String word) {
        if (word.length() != WORD_LENGTH) {
            throw new InvalidWordException("단어는 5글자여야 합니다. (" + word + ")");
        }

        this.letters = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            Letter letter = new Letter(word.charAt(i), i);
            this.letters.add(letter);
        }
    }

    public Results compare(Word targetWord) {
        WordComparator wordComparator = new WordComparator(this.letters);
        return wordComparator.compare(targetWord);
    }

    static class WordComparator {

        private final List<Letter> pendingLetters;
        private final Results results;

        public WordComparator(List<Letter> letters) {
            this.pendingLetters = new ArrayList<>(letters);
            this.results = new Results();
        }

        public Results compare(Word targetWord) {
            for (Letter letter : targetWord) {
                process(letter, letter::equals, Tile.GREEN);
            }

            for (Letter letter : targetWord) {
                process(letter, letter::isSameAlphabet, Tile.YELLOW);
            }

            for (Letter letter : targetWord) {
                fillEmptyToGray(letter);
            }

            return results;
        }

        private void process(Letter targetLetter, Predicate<Letter> predicate, Tile tile) {
            Position position = targetLetter.getPosition();
            if (results.isCheckedPosition(position)) {
                return;
            }

            pendingLetters.stream()
                    .filter(predicate)
                    .findFirst()
                    .ifPresent(letter -> {
                        pendingLetters.remove(letter);
                        results.add(new Result(tile, position));
                    });
        }

        private void fillEmptyToGray(Letter targetLetter) {
            Position position = targetLetter.getPosition();
            if (results.isCheckedPosition(position)) {
                return;
            }

            pendingLetters.forEach(
                    letter -> results.add(new Result(Tile.GRAY, position)));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Word word = (Word) o;
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
