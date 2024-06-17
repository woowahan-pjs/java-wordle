package wordle;

import java.time.LocalDate;
import java.util.List;

public class WordService {

    private static final LocalDate CUTOFF_DATE = LocalDate.of(2021, 6, 19);

    private final WordsReader wordsReader;

    public WordService(WordsReader wordsReader) {
        this.wordsReader = wordsReader;
    }

    public Words getWords() {
        List<String> wordList = wordsReader.read();
        return new Words(wordList, CUTOFF_DATE);
    }
}
