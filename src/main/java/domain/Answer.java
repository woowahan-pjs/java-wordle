package domain;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Answer {
    private String value;

    public Answer(String value) {
        this.value = value;
    }

    Boolean exists(char inputChar) {
        return true;
    }

    Boolean isCorrect(int index, char inputChar) {
        return true;
    }

    public static Answer from(List<String> avaliableWords) {
        LocalDate currentDate = LocalDate.now();
        LocalDate fixedDate = LocalDate.of(2021, 6, 19);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        int formattedDate = Integer.parseInt(currentDate.format(formatter));
        int fixedFormattedDate = Integer.parseInt(fixedDate.format(formatter));

        int idx = (formattedDate - fixedFormattedDate) % avaliableWords.size();

        return new Answer(avaliableWords.get(idx));
    }
}
