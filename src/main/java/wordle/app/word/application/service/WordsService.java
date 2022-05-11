package wordle.app.word.application.service;

import camp.nextstep.edu.missionutils.Console;
import wordle.app.word.application.port.InputWordsPort;
import wordle.app.word.domain.Answer;
import wordle.app.match.domain.MatchResult;
import wordle.app.word.domain.Words;

public class WordsService implements InputWordsPort {

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
