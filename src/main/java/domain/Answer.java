package domain;

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
        return value.charAt(index) == inputChar;
    }


    public MatchResult match(InputWord inputWord) {
        MatchResult matchResult = new MatchResult();
        for(int i = 0; i< inputWord.getLength(); i++){
            char c = inputWord.getCharBy(i);
            if(isCorrect(i, c)){
                matchResult.add(Hint.CORRECT);
                continue;
            }
            if(exists(c)){
                matchResult.add(Hint.EXIST);
                continue;
            }
            matchResult.add(Hint.NOT_EXIST);
        }
        return matchResult;
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
