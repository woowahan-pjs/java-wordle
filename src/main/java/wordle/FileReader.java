package wordle;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {

    public List<String> readAll(String filename) {
        try {
            Path path = Paths.get(ClassLoader.getSystemResource(filename).toURI());

            return Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException("file load failed!!!!!", e); // TODO: change message
        }
    }
}
