package wordle.app.bucket.application.service;

import wordle.app.bucket.application.port.in.ContainWordsPort;
import wordle.app.bucket.application.port.in.FindAnswerPort;
import wordle.app.bucket.domain.WordsBucket;
import wordle.app.word.domain.Answer;
import wordle.app.word.domain.Words;

import java.time.LocalDate;

public class WordsBucketService implements ContainWordsPort, FindAnswerPort {

    private final WordsBucket wordsBucket;

    public WordsBucketService(final WordsBucket wordsBucket) {
        this.wordsBucket = wordsBucket;
    }

    @Override
    public boolean contains(final Words words) {
        return wordsBucket.contains(words);
    }

    @Override
    public Answer findAnswer() {
        return wordsBucket.findAnswer(LocalDate.now());
    }
}
