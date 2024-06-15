package kr.co.wordle;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import static kr.co.wordle.WordleGameConfig.WORDS_FILE_PATH;

public class WordFileReader {

    private WordFileReader() {
    }

    public static List<String> readWordsInFile() {
        try {
            URL resource = AnswerProvider.class.getClassLoader().getResource(WORDS_FILE_PATH);
            if (resource != null) {
                return Files.readAllLines(Paths.get(resource.toURI()));
            }
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
