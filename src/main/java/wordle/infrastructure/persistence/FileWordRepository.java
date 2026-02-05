package wordle.infrastructure.persistence;

import wordle.domain.word.WordRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class FileWordRepository implements WordRepository {

    private final Set<String> wordSet = new HashSet<>();
    private final List<String> wordList = new ArrayList<>();

    public FileWordRepository() {
        this("words.txt");
    }

    public FileWordRepository(String resourcePath) {
        loadWords(resourcePath);
    }

    private void loadWords(String resourcePath) {
        try (var inputStream = getClass().getClassLoader().getResourceAsStream(resourcePath)) {
            if (inputStream == null) {
                throw new IOException("Resource not found: " + resourcePath);
            }

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    String word = line.trim().toLowerCase();
                    if (!word.isEmpty()) {
                        wordSet.add(word);
                        wordList.add(word);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("WordRepository initialization failed: " + e.getMessage(), e);
        }
    }

    @Override
    public boolean hasWord(String word) {
        return wordSet.contains(word.toLowerCase());
    }

    @Override
    public List<String> getWordList() {
        return Collections.unmodifiableList(wordList);
    }
}
