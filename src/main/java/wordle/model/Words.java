package wordle.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class Words {

    private final List<String> words;
    private final LocalDate cutoffDate;

    public Words(List<String> wordList, LocalDate cutoffDate) {
        this.words = wordList;
        this.cutoffDate = cutoffDate;
    }

    public String getWordOfDay(LocalDate localDate) {
        int diffDay = Period.between(cutoffDate, localDate).getDays();
        int wordIndex = diffDay % words.size();
        return words.get(wordIndex);
    }

    public boolean notContains(String input) {
        return !words.contains(input);
    }
}
