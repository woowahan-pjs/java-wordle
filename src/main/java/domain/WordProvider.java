package domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WordProvider {
    public List<String> loadWordFile(String filePath) {
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
}
