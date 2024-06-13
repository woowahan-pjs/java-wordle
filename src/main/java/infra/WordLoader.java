
package infra;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class WordLoader {

    public  WordLoader() {
    }

    public static List<String> read(String filePath) {
        try {
            return Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
