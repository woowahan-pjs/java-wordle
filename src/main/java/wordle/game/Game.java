package wordle.game;

import camp.nextstep.edu.missionutils.Console;
import wordle.domain.Words;
import wordle.domain.WordsBucket;

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
            playingInfo.play();
            inputWords();
            playingInfo.updateStatus(isCorrectWords());
            gameView.wordsMatchResults(playingInfo.getCurrentMatchResults());
        } while (!playingInfo.isFinish());
    }

    private boolean isCorrectWords() {
        return playingInfo.matches();
    }

    private void inputWords() {
        do {
            gameView.inputWords();
        } while (!doInputWordsSuccess());
    }

    private boolean doInputWordsSuccess() {
        try {
            playingInfo.updateCurrentWords(new Words(Console.readLine()));
            return wordsBucket.contains(playingInfo.getCurrentWords());
        } catch (final IllegalArgumentException e) {
            gameView.errors(e);
        }
        return false;
    }

    private void end() {
        if (playingInfo.isCorrect()) {
            gameView.round(playingInfo.getCurrentRound());
        }
    }

}
