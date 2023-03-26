package domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class WordProvider {
    private final List<String> words;
    private final LocalDate criteriaDate;

    public WordProvider(String filePath, LocalDate criteriaDate) {
        this.words = getWordList(filePath);
        this.criteriaDate = criteriaDate;
    }

    public List<String> getWordList(String filePath) {
        Path path = Path.of(filePath);
        List<String> words;
        try {
            words = Files.readAllLines(path);
        } catch (IOException e) {
            throw new IllegalArgumentException("파일 변환중에 err가 발생하였습니다.");
        }
        if (words.isEmpty()) {
            throw new IllegalArgumentException("파일이 비어있습니다.");
        }
        return words;
    }

    public String getAnswer(LocalDate currentDate) {
        Period period = Period.between(criteriaDate, currentDate);
        int days = period.getDays();
        return words.get(days % words.size());
    }
}
