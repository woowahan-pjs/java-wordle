package wordle.game;

import wordle.domain.Words;
import wordle.domain.WordsBucket;
import wordle.domain.WordsMatchResult;

import java.time.LocalDate;

public class Game {

    private final WordsBucket wordsBucket;
    private final GameView gameView;
    private final PlayingInfo playingInfo;

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
        playingInfo.init(wordsBucket.findAnswer(LocalDate.now()));
    }

    private void start() {
        do {
            startRound();
            inputWords();
            updateMatchesResult(matches());
        } while (!playingInfo.isFinish());
    }

    private void startRound() {
        playingInfo.play();
    }

    private void inputWords() {
        do {
            gameView.inputWords();
        } while (!doInputWordsSuccess());
    }

    private boolean doInputWordsSuccess() {
        try {
            final Words words = playingInfo.inputWords();
            return wordsBucket.contains(words);
        } catch (final IllegalArgumentException e) {
            gameView.errors(e);
        }
        return false;
    }

    private WordsMatchResult matches() {
        return playingInfo.matches();
    }

    private void updateMatchesResult(final WordsMatchResult matchResult) {
        playingInfo.updateResult(matchResult);
        gameView.wordsMatchResults(playingInfo.getCurrentMatchResults());
    }

    private void end() {
        if (playingInfo.isCorrect()) {
            gameView.round(playingInfo.getCurrentRound());
        }
    }

}
