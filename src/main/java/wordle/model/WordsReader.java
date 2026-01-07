package wordle.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WordsReader {

    private static final String WORDS_FILE_PATH = "src/main/resources/words.txt";

    public List<String> read() {
        Path path = Path.of(WORDS_FILE_PATH);

        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException("파일 읽기에 실패했습니다.");
        }
    }
}
