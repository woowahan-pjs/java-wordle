package domain;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class WordDictionary {
    private final List<Word> words;

    public WordDictionary(List<String> words) {
        this.words = words.stream()
                .map(Word::new)
                .toList();
    }

    public Word answerWord(LocalDate currentDate) {
        int index = getIndex(currentDate);
        return words.get(index);
    }

    public boolean hasNot(Word word) {
        return !words.contains(word);
    }

    private int getIndex(LocalDate currentDate) {
        LocalDate fixedDate = LocalDate.of(2021, 6, 19);
        int diffDay = Period.between(fixedDate, currentDate).getDays();
        return diffDay % words.size();
    }
}
