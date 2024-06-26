package wordle.model;

import java.time.LocalDate;
import java.util.List;

public class Words {

    private final List<String> words;
    private final LocalDate cutoffDate;

    public Words(List<String> wordList, LocalDate cutoffDate) {
        this.words = wordList;
        this.cutoffDate = cutoffDate;
    }

    public String getWordOfDay(LocalDate localDate) {
        long nowEpochDay = localDate.toEpochDay();
        long cutoffEpochDay = cutoffDate.toEpochDay();
        int wordIndex = (int) (nowEpochDay - cutoffEpochDay) % words.size();
        return words.get(wordIndex);
    }

    public boolean notContains(String input) {
        return !words.contains(input);
    }
}
