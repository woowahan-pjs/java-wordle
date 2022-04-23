package test.wordle.domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class WordsBucket {

    private final List<Words> words = new ArrayList<>();

    public WordsBucket(final String filePath) {
        final List<String> lines;
        try {
            lines = Files.readAllLines(Path.of(filePath));
        } catch (final IOException e) {
            throw new IllegalArgumentException("Invalid file path: " + filePath);
        }

        for (final String line : lines) {
            words.add(new Words(line));
        }
    }

    public int size() {
        return words.size();
    }
}
