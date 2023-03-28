package domain;

import java.util.Objects;

public class CorrectAnswer {

    private final Word result;

    public CorrectAnswer(Word result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CorrectAnswer that = (CorrectAnswer) o;
        return Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }
}
