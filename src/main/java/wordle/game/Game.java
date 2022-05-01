package wordle.game;

import camp.nextstep.edu.missionutils.Console;
import wordle.domain.Answer;
import wordle.domain.Words;
import wordle.domain.WordsBucket;
import wordle.domain.WordsMatchResult;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private final WordsBucket wordsBucket;
    private final GameView gameView;
    private final List<WordsMatchResult> wordsMatchResults;
    private final Round round;
    private Answer answer;
    private Words inputWords;
    private boolean isCorrect;

    public Game(final String filePath, final GameView gameView) {
        wordsBucket = new WordsBucket(filePath);
        this.gameView = gameView;
        wordsMatchResults = new ArrayList<>();
        round = new Round();
    }

    public void play() {
        init();
        start();
        end();
    }

    private void end() {
        if (isCorrect) {
            gameView.round(round);
        }
    }

    private void start() {
        do {
            round.start();
            inputWords();
            isCorrect = isCorrectWords();
            gameView.wordsMatchResults(wordsMatchResults);

        } while (!round.isFinish() && !isCorrect);
    }

    private void init() {
        gameView.initGame();
        answer = wordsBucket.findAnswer(LocalDate.now());
    }

    private boolean isCorrectWords() {
        final WordsMatchResult result = answer.matches(inputWords);
        wordsMatchResults.add(result);
        return result.isCorrect();
    }

    private void inputWords() {
        do {
            gameView.inputWords();
        } while (!doInputWordsSuccess());
    }

    private boolean doInputWordsSuccess() {
        try {
            this.inputWords = new Words(Console.readLine());
            return wordsBucket.contains(inputWords);
        } catch (final IllegalArgumentException e) {
            gameView.errors(e);
        }
        return false;
    }

    static class Round {

        private static final int LAST_ROUND = 6;
        private int currentRound = 0;

        public boolean isFinish() {
            return currentRound >= LAST_ROUND;
        }

        public void start() {
            currentRound++;
        }

        @Override
        public String toString() {
            return currentRound + "/" + LAST_ROUND;
        }
    }

}
