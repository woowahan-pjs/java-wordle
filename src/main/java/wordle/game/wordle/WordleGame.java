package wordle.game.wordle;

import wordle.domain.*;
import wordle.game.base.Game;

import java.time.LocalDate;

public class WordleGame extends Game {

    private final WordsBucket wordsBucket;
    private final Player player;
    private final WordleGameView gameView;
    private final PlayingInfo playingInfo;

    public WordleGame(final String filePath) {
        this.wordsBucket = new WordsBucket(filePath);
        this.playingInfo = new PlayingInfo(wordsBucket.findAnswer(LocalDate.now()));
        this.gameView = new WordleGameView();
        this.player = new Player();
    }

    @Override
    protected void init() {
        gameView.initGame();
    }

    @Override
    protected void start() {
        do {
            startRound();
            inputWords();
            updateMatchesResult(matches());
        } while (!playingInfo.isFinish());
    }

    private void startRound() {
        playingInfo.start();
    }

    private void inputWords() {
        do {
            gameView.inputWords();
        } while (!doInputWordsSuccess());
    }

    private boolean doInputWordsSuccess() {
        try {
            this.playingInfo.words = player.inputWords();
            return wordsBucket.contains(playingInfo.words);
        } catch (final IllegalArgumentException e) {
            gameView.errors(e);
        }
        return false;
    }

    private MatchResult matches() {
        return playingInfo.matches();
    }

    private void updateMatchesResult(final MatchResult matchResult) {
        playingInfo.updateResult(matchResult);
        gameView.wordsMatchResults(playingInfo.matchResults);
    }

    @Override
    protected void complete() {
        if (playingInfo.isCorrect()) {
            gameView.round(playingInfo.round);
        }
    }

    private static class PlayingInfo {

        private final Answer answer;
        private final Round round;
        private final MatchResults matchResults;
        private Words words;
        private PlayingStatus status;

        PlayingInfo(final Answer answer) {
            this.answer = answer;
            this.round = new Round();
            this.matchResults = new MatchResults();
            this.status = PlayingStatus.PLAYING;
        }

        void updateResult(final MatchResult matchResult) {
            if (matchResult.isCorrect()) {
                this.status = PlayingStatus.FINISH_CORRECT;
            }
            matchResults.add(matchResult);
        }

        boolean isFinish() {
            return status.isFinish;
        }

        boolean isCorrect() {
            return status == PlayingStatus.FINISH_CORRECT;
        }

        void start() {
            round.start();
            if (round.isFinish()) {
                this.status = PlayingStatus.FINISH_INCORRECT;
            }
        }

        MatchResult matches() {
            return answer.matches(words);
        }

        private enum PlayingStatus {
            PLAYING(false),
            FINISH_INCORRECT(true),
            FINISH_CORRECT(true),
            ;

            private final boolean isFinish;

            PlayingStatus(final boolean isFinish) {
                this.isFinish = isFinish;
            }
        }

    }

}
