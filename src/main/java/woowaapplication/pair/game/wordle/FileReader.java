package woowaapplication.pair.game.wordle;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import woowaapplication.pair.game.wordle.exception.ReadFileException;

public class FileReader {

    public static List<String> readLinesFromFile(URL fileUrl) {
        try {
            return Files.readAllLines(Paths.get(fileUrl.toURI()));
        } catch (IOException | URISyntaxException e) {
            throw new ReadFileException();
        }
    }
}
