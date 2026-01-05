package wordle.domain;

import java.util.Objects;

public class Letter {
    // TODO: validate 0 < position < 5
    private final int position;
    private final char ch;

    public Letter(int position, char ch) {
        validateAlpha(ch);
        this.ch = ch;
        this.position = position;
    }

    public char getValue() {
        return ch;
    }

    // TODO: Result를 반환하는게 맞는지 고민 필요
    public Result compare(Letter target) {
        if (equals(target)) {
            return Result.CORRECT;
        }
        if (hasSameValueAndDiffPosition(target)) {
            return Result.HALF_CORRECT;
        }
        return Result.WRONG;
    }

    public boolean hasSameValueAndDiffPosition(Letter target) {
        return this.position != target.position && this.ch == target.ch;
    }

    private void validateAlpha(char ch) {
        if (ch > 'z' || ch < 'a') {
            throw new IllegalArgumentException("shoud be alphabet");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Letter letter = (Letter) o;
        return position == letter.position && ch == letter.ch;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, ch);
    }
}
