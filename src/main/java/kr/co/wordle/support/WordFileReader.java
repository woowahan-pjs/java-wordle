package kr.co.wordle.support;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static kr.co.wordle.config.WordleGameConfig.WORDS_FILE_PATH;

public class WordFileReader {

    private WordFileReader() {
    }

    public static List<String> readWordsInFile() {
        Path wordsFilePath = Path.of(WORDS_FILE_PATH);
        try {
            return Files.readAllLines(wordsFilePath);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
