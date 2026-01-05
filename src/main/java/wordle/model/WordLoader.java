package wordle.model;

import java.time.LocalDate;
import java.util.List;

public class WordLoader {

    private static final LocalDate CUTOFF_DATE = LocalDate.of(2021, 6, 19);

    private final Words words;

    public WordLoader(WordsReader wordsReader) {
        List<String> wordList = wordsReader.read();
        words = new Words(wordList, CUTOFF_DATE);
    }

    public Letters getAnswer() {
        String wordOfDay = words.getWordOfDay(LocalDate.now());
        return new Letters(wordOfDay);
    }

    public boolean isNotIncludedWord(String input) {
        return words.notContains(input);
    }
}
