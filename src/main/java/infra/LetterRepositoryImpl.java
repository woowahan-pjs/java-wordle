package infra;

import domain.LetterRepository;
import domain.Letters;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class LetterRepositoryImpl implements LetterRepository {
    private static final String FILE_NAME = "words.txt";
    private static final LocalDate criteriaDate = LocalDate.of(2021, 6, 19);

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
        URL resource = LetterRepositoryImpl.class.getClassLoader().getResource(FILE_NAME);
        Path path = new File(resource.getPath()).toPath();
        List<String> contents = null;
        try {
            contents = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return contents.stream()
                .map(Letters::of)
                .collect(Collectors.toList());
    }
}
