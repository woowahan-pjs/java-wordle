package wordle.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Word {
    private static final int MAX_LENGTH = 5;
    private final List<Letter> letters;

    public Word(String text) {
        validateLength(text);

        letters = new ArrayList<>();
        int index = 0;
        for (char ch : text.toCharArray()) {
            letters.add(new Letter(index++, ch));
        }
    }

    public String castWordsToString() {
        StringBuilder wordsToString = new StringBuilder();

        for (Letter letter : letters) {
            wordsToString.append(letter.getValue());
        }

        return wordsToString.toString();
    }

    private void validateLength(String text) {
        if (text.length() != MAX_LENGTH) {
            throw new IllegalArgumentException("text length cannot be over than MAX_LENGTH");
        }
    }

    // 우선순위
    //  완전일치 있으면 반환
    //  포지션만 다른거 있으면 반환
    //  아니면 다르다고 반환
    private Result check(Letter target) {
        if (letters.contains(target)) {
            return Result.CORRECT;
        }
        if (containsDiffPosition(target)) {
            return Result.HALF_CORRECT;
        }
        return Result.WRONG;
    }

    private boolean containsDiffPosition(Letter target) {
        return letters.stream()
                .anyMatch(letter -> letter.hasSameValueAndDiffPosition(target));
    }

    public List<Result> compare(Word target) {
        List<Result> list = new ArrayList<>();
        for (Letter letter : target.letters) {
            Result check = check(letter);
            list.add(check);
        }
        return list;
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
