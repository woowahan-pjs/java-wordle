package wordle.app.word.application.service;

import camp.nextstep.edu.missionutils.Console;
import wordle.app.word.domain.WordsBucket;
import wordle.app.word.application.port.ContainWordsPort;
import wordle.app.word.application.port.FindAnswerPort;
import wordle.app.word.application.port.InputWordsPort;
import wordle.app.word.domain.Answer;
import wordle.app.word.domain.Words;

import java.time.LocalDate;

public class WordsService implements ContainWordsPort, FindAnswerPort, InputWordsPort {

    private final WordsBucket wordsBucket;

    public WordsService(final WordsBucket wordsBucket) {
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
