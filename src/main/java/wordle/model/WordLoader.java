package wordle.model;

import java.time.LocalDate;
import java.util.List;

public class WordLoader {

    private static final LocalDate CUTOFF_DATE = LocalDate.of(2021, 6, 19);

    private final WordsReader wordsReader;

    public WordLoader(WordsReader wordsReader) {
        this.wordsReader = wordsReader;
    }

    public Words getWords() {
        List<String> wordList = wordsReader.read();
        return new Words(wordList, CUTOFF_DATE);
    }
}
