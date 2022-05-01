package wordle.game;

import wordle.domain.WordsMatchResult;
import wordle.domain.WordsMatchResults;

import java.util.List;

public final class GameView {

    public void initGame() {
        System.out.println("WORDLE을 6번 만에 맞춰 보세요.\n시도의 결과는 타일의 색 변화로 나타납니다.");
    }

    public void round(final Game.Round round) {
        System.out.println(round);
    }

    public void wordsMatchResults(final WordsMatchResults wordsMatchResults) {
        System.out.println(wordsMatchResults);
    }

    public void inputWords() {
        System.out.println("정답을 입력해 주세요.");
    }

    public void errors(final Exception e) {
        System.out.println(e.getMessage());
    }
}
