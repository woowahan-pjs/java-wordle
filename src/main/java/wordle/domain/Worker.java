package wordle.domain;

import wordle.domain.generator.DefaultGenerator;
import wordle.domain.generator.IndexGenerator;
import wordle.domain.word.Word;

import java.util.List;

public class Worker {
    private final List<Word> words;
    private final IndexGenerator indexGenerator;

    public Worker(List<Word> words) {
        this(words, new DefaultGenerator());
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
