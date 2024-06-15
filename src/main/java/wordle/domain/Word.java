package wordle.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import wordle.exception.InvalidWordException;

public class Word implements Iterable<Letter> {

    public static final int WORD_LENGTH = 5;
    private final List<Letter> letters;

    public Word(String input) {
        if (input.length() != WORD_LENGTH) {
            throw new InvalidWordException();
        }

        this.letters = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            Letter letter = new Letter(input.charAt(i), i);
            this.letters.add(letter);
        }
    }

    public Results compare(Word inputWord) {
        CurrentResult currentResult = new CurrentResult(new ArrayList<>(this.letters));
        for (Letter letter : inputWord) {
            currentResult.findGreen(letter);
        }

        for (Letter letter : inputWord) {
            currentResult.findYellow(letter);
        }

        for (Letter letter : inputWord) {
            currentResult.fillEmptyToGray(letter);
        }

        return currentResult.results;
    }

    static class CurrentResult {

        private final List<Letter> letters;
        private final Results results;

        public CurrentResult(List<Letter> letters) {
            this.letters = letters;
            this.results = new Results();

        }

        public void findGreen(Letter targetLetter) {
            for (Letter letter : letters) {
                if (letter.equals(targetLetter)) {
                    letters.remove(letter);
                    results.add(new Result(Tile.GREEN, targetLetter.getPosition()));
                    return;
                }
            }
        }

        public void findYellow(Letter targetLetter) {
            for (Letter letter : letters) {
                if (letter.isSameAlphabet(targetLetter)) {
                    letters.remove(letter);
                    results.add(new Result(Tile.YELLOW, targetLetter.getPosition()));
                    return;
                }
            }
        }

        public void fillEmptyToGray(Letter targetLetter) {
            letters.forEach(letter -> results.add(new Result(Tile.GRAY, targetLetter.getPosition())));
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
