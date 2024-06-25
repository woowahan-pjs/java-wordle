package wordle.domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DictionaryFileReader implements DictionaryReader {
    private static final String FILE_PATH = "src/main/resources/words.txt";
    private static final Dictionary DICTIONARY;

    static {
        try {
            final Path path = Paths.get(FILE_PATH);
            DICTIONARY = new Dictionary(Files.readAllLines(path)
                    .stream()
                    .map(DictionaryWord::new)
                    .toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Dictionary read() {
        return DICTIONARY;
    }
}
