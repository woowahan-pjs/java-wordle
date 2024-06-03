package wordle.app.word.application.service;

import camp.nextstep.edu.missionutils.Console;
import wordle.app.word.application.port.out.WordsBucketPort;
import wordle.app.word.application.port.in.ContainWordsPort;
import wordle.app.word.application.port.in.FindAnswerPort;
import wordle.app.word.application.port.in.InputWordsPort;
import wordle.app.word.domain.Answer;
import wordle.app.word.domain.Words;

import java.time.LocalDate;

public class WordsService implements ContainWordsPort, FindAnswerPort, InputWordsPort {

    private final WordsBucketPort wordsBucket;

    public WordsService(final WordsBucketPort wordsBucket) {
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

    @Override
    public Words inputWords() {
        Words words;
        do {
            words = inputWordsFromPlayer();
        } while (words == null);

        return words;
    }

    private Words inputWordsFromPlayer() {
        Words words;
        try {
            words = new Words(Console.readLine());
        } catch (final IllegalArgumentException e) {
            words = null;
        }

        return words;
    }

}
