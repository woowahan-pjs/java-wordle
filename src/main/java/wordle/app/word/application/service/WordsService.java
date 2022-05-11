package wordle.app.word.application.service;

import camp.nextstep.edu.missionutils.Console;
import wordle.app.word.application.port.InputWordsPort;
import wordle.app.word.domain.Answer;
import wordle.app.word.domain.MatchResult;
import wordle.app.word.domain.Words;
import wordle.app.word.application.port.MatchWordsPort;

public class WordsService implements InputWordsPort, MatchWordsPort {

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

    @Override
    public MatchResult matches(final Answer answer, final Words words) {
        return answer.matches(words);
    }

}
