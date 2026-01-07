package wordle.domain.word;

import wordle.domain.Result;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Word {
    private static final int MAX_LENGTH = 5;

    private final List<PositionLetter> letters;

    private Word(List<PositionLetter> letters) {
        this.letters = letters;
    }

    public static Word fromString(String text) {
        validateLength(text);

        AtomicInteger position = new AtomicInteger(0);
        List<PositionLetter> positionLetters = Arrays.stream(text.split(""))
                .map(value -> PositionLetter.of(position.getAndIncrement(), value.charAt(0)))
                .collect(Collectors.toList());

        return new Word(positionLetters);
    }

    private static void validateLength(String text) {
        if (text.length() != MAX_LENGTH) {
            throw new IllegalArgumentException("text length cannot be over than MAX_LENGTH");
        }
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

    private boolean containsDiffPosition(PositionLetter target) {
        return letters.stream()
                .anyMatch(letter -> letter.hasSameValueAndDiffPosition(target));
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
