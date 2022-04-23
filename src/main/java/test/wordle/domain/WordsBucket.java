package test.wordle.domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;import java.util.ArrayList;
import java.util.List;


public class WordsBucket {
    final List<Words> words = new ArrayList<>();

    public List<Words> readWordsFile(final String filePath) {
        try {
            final List<String> tmp = Files.readAllLines(Path.of(filePath));
            for (String word : tmp) {
                words.add(new Words(word));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }
}
