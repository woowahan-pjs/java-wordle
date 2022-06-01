package wordle.domain;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public class WordFile {
    private static final String FILE_PATH = "src/main/resources/";
    private final List<String> wordList = new ArrayList<>();

    public WordFile(String fileName) throws FileNotFoundException {
        try {
            wordList.addAll(Files.readAllLines(Path.of(FILE_PATH + fileName)));
        } catch (IOException ioe) {
            throw new FileNotFoundException("존재하는 유효한 파일이 필요합니다.");
        }
    }

    public String findGoalWord(LocalDate givenDate) {
        final LocalDate conditionDate = LocalDate.of(2021, 6, 19);

        final long diffDays = DAYS.between(conditionDate, givenDate);

        final int targetIdx = Math.abs((int) diffDays % wordList.size());

        return wordList.get(targetIdx);
    }
}
