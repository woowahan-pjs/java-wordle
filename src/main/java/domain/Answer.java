package domain;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Objects;

public class Answer {
    private String value;

    public Answer(String value) {
        this.value = value;
    }

    public Answer(LocalDate currentDate, List<String> availableWords) {
        LocalDate fixedDate = LocalDate.of(2021, 6, 19);
        int diffDay = Period.between(fixedDate, currentDate).getDays();
        int index = diffDay % availableWords.size();
        this.value = availableWords.get(index);
    }
    Boolean exists(char inputChar) {
        return value.indexOf(inputChar) != -1;
    }

    Boolean isCorrect(int index, char inputChar) {
        return value.indexOf(inputChar) == index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Answer answer = (Answer) o;

        return Objects.equals(value, answer.value);
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}
