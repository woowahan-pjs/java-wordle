package wordle.game;

import camp.nextstep.edu.missionutils.Console;
import wordle.domain.*;

import java.time.LocalDate;

public class Game {

    private final WordsBucket wordsBucket;
    private final GameView gameView;
    private final PlayingInfo playingInfo;
    private Answer answer;

    public Game(final String filePath, final GameView gameView) {
        this.wordsBucket = new WordsBucket(filePath);
        this.gameView = gameView;
        this.playingInfo = new PlayingInfo();
    }

    public void play() {
        init();
        start();
        end();
    }

    private void init() {
        gameView.initGame();
        playingInfo.init();
        answer = wordsBucket.findAnswer(LocalDate.now());
    }

    private void start() {
        do {
            playingInfo.playRound();
            inputWords();
            playingInfo.updateStatus(isCorrectWords());
            gameView.wordsMatchResults(playingInfo.getCurrentMatchResults());
        } while (!playingInfo.isFinish());
    }

    private boolean isCorrectWords() {
        final WordsMatchResult result = answer.matches(playingInfo.inputWords);
        playingInfo.addMatchResults(result);
        return result.isCorrect();
    }

    private void inputWords() {
        do {
            gameView.inputWords();
        } while (!doInputWordsSuccess());
    }

    private boolean doInputWordsSuccess() {
        try {
            playingInfo.updateCurrentInputWords(new Words(Console.readLine()));
            return wordsBucket.contains(playingInfo.inputWords);
        } catch (final IllegalArgumentException e) {
            gameView.errors(e);
        }
        return false;
    }

    private void end() {
        if (playingInfo.isCorrect) {
            gameView.round(playingInfo.round);
        }
    }

    private static class PlayingInfo {
        private WordsMatchResults wordsMatchResults;
        private Round round;
        private Words inputWords;
        private boolean isCorrect;

        void init() {
            round = new Round();
            wordsMatchResults = new WordsMatchResults();
        }

        void playRound() {
            round.start();
        }

        void updateStatus(final boolean isCorrect) {
            this.isCorrect = isCorrect;
        }

        public boolean isFinish() {
            return round.isFinish() || isCorrect;
        }

        private WordsMatchResults getCurrentMatchResults() {
            return wordsMatchResults;
        }

        private void updateCurrentInputWords(final Words words) {
            this.inputWords = words;
        }

        public void addMatchResults(final WordsMatchResult result) {
            wordsMatchResults.add(result);
        }
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
