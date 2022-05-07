package wordle.in;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import wordle.domain.design.WordGenerator;

public class WordGeneratorImpl implements WordGenerator {

    // words.txt 파일을 배열로 만들어서 ((현재 날짜 - 2021년 6월 19일) % 배열의 크기) 번째의 단어를 반환한다

    private static final List<String> WORDS = readFile();
    private static final String REFERENCE_DATE = "2021-06-19";

    @Override
    public String execute() {
        return WORDS.get(findIndex());
    }

    private static List<String> readFile() {
        return List.of("apple", "adult", "judge", "rower", "artsy", "rural", "shave");
    }

    private int findIndex() {
        LocalDate now = LocalDate.now();
        LocalDate referenceDay = LocalDate.parse(REFERENCE_DATE, DateTimeFormatter.ISO_LOCAL_DATE);
        Duration diff = Duration.between(now.atStartOfDay(), referenceDay.atStartOfDay());
        long diffDays = Math.abs(diff.toDays());
        return (int) (diffDays % WORDS.size());
    }
}
