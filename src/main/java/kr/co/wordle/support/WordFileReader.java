package kr.co.wordle.support;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import static kr.co.wordle.config.WordleGameConfig.WORDS_FILE_PATH;

public class WordFileReader {

    private WordFileReader() {
    }

    public static List<String> readWordsInFile() {
        URL resource = WordFileReader.class.getClassLoader().getResource(WORDS_FILE_PATH);
        if (resource == null) {
            return Collections.emptyList();
        }
        return readAllLines(resource);
    }

    private static List<String> readAllLines(URL resource) {
        try {
            return Files.readAllLines(Paths.get(resource.toURI()));
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
