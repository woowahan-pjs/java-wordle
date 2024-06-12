package wordle.domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class WordListFileReader implements WordListReader {
    private static final String FILE_PATH = "src/main/resources/words.txt";
    private static final WordList wordList = initializeWordList();

    private static WordList initializeWordList() {
        try {
            final Path path = Paths.get(FILE_PATH);
            return new WordList(Files.readAllLines(path)
                    .stream()
                    .map(Word::new)
                    .toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WordList read() {
        return wordList;
    }
}
