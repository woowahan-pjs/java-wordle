package wordle.domain;

import wordle.domain.word.Word;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class Worker {

    private final List<Word> words;
    private final IndexGenerator indexGenerator;

    public Worker(List<Word> words) {
        this.words = words;
        this.indexGenerator = new DefaultGenerator();
    }

    public Worker(List<Word> words, IndexGenerator indexGenerator) {
        this.words = words;
        this.indexGenerator = indexGenerator;
    }

    public Word proposeQuestion() {
        int index = indexGenerator.get(words.size());
        return words.get(index);
    }

    public boolean isAnswerEmbedded(Word userInputAnswer) {
        return words.contains(userInputAnswer);
    }
}

class DefaultGenerator implements IndexGenerator {

    public int get(int size) {
        long todayToEpochDay = LocalDate.now().toEpochDay();
        long standardDateToEpochDay = LocalDate.of(2021, Month.JUNE, 19).toEpochDay();
        return (int) ((todayToEpochDay - standardDateToEpochDay) % size);
    }
}
