package domain;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class LetterRepositoryImpl implements LetterRepository {
    private static final String FILE_NAME = "words.txt";

    public List<Letters> findAll() {
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
