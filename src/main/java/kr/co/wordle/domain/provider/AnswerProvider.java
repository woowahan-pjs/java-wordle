package kr.co.wordle.domain.provider;

import kr.co.wordle.support.WordFileReader;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class AnswerProvider {

    private static final LocalDate REFERENCE_DATE = LocalDate.of(2021, 6, 19);

    private AnswerProvider() {
    }

    public static String todayAnswer() {
        List<String> words = WordFileReader.readWordsInFile();
        int dayDiff = dayDiff();
        return words.get(dayDiff % words.size());
    }

    private static int dayDiff() {
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(REFERENCE_DATE, currentDate);
        return period.getDays();
    }
}
