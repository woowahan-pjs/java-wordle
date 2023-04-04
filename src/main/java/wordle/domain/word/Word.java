package wordle.domain.word;

import wordle.domain.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Word {
    private static final int MAX_LENGTH = 5;

    private final List<PositionLetter> letters;

    public Word(String text) {
        validateLength(text);

        letters = new ArrayList<>();
        int index = 0;
        for (char ch : text.toCharArray()) {
            PositionLetter letter = PositionLetter.of(index++, ch);
            letters.add(letter);
        }
    }

    private void validateLength(String text) {
        if (text.length() != MAX_LENGTH) {
            throw new IllegalArgumentException("text length cannot be over than MAX_LENGTH");
        }
    }

    private boolean containsDiffPosition(PositionLetter target) {
        return letters.stream()
                .anyMatch(letter -> letter.hasSameValueAndDiffPosition(target));
    }

    public List<Result> compare(Word target) {
        return target.letters.stream()
                .map(this::compareLetter)
                .collect(Collectors.toList());
    }

    private Result compareLetter(PositionLetter target) {
        if (letters.contains(target)) {
            return Result.CORRECT;
        }
        if (containsDiffPosition(target)) {
            return Result.HALF_CORRECT;
        }
        return Result.WRONG;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return Objects.equals(letters, word.letters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(letters);
    }
}
