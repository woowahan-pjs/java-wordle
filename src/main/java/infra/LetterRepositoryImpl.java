package infra;

import domain.LetterRepository;
import domain.Letters;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class LetterRepositoryImpl implements LetterRepository {
    private static final String FILE_ERROR = "words.txt 파일을 확인하세요. 변환에 문제가 생겼습니다.";
    private static final String PATH = "src/main/resources/words.txt";
    private static final LocalDate criteriaDate = LocalDate.of(2021, 6, 19);

    @Override
    public Letters getTodayAnswer(LocalDate today) {
        List<Letters> letters = findAll();
        int key = (int) ((today.toEpochDay() - criteriaDate.toEpochDay()) % letters.size());
        return letters.get(key);
    }

    @Override
    public boolean isContains(Letters userAnswer) {
        List<Letters> letters = findAll();
        return letters.contains(userAnswer);
    }

    private List<Letters> findAll() {
        List<String> contents;
        try {
            contents = Files.readAllLines(Path.of(PATH));
        } catch (IOException e) {
            throw new IllegalArgumentException(FILE_ERROR);
        }

        return contents.stream()
                .map(Letters::of)
                .collect(Collectors.toList());
    }
}
