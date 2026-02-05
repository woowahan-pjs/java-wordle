package wordle.domain.word;

import java.util.Objects;

public record Answer(String value) {
    public Answer {
        java.util.Objects.requireNonNull(value, "Answer value cannot be null");
    }
}
