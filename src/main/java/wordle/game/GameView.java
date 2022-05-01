package wordle.game;

import wordle.domain.WordsMatchResult;

import java.util.List;

public final class GameView {

    public void initGame() {
        System.out.println("WORDLE을 6번 만에 맞춰 보세요.\n시도의 결과는 타일의 색 변화로 나타납니다.");
    }

    public void round(final Game.Round round) {
        System.out.println(round);
    }

    public void wordsMatchResults(final List<WordsMatchResult> wordsMatchResults) {
        wordsMatchResults.forEach(v -> System.out.println(v.getMatchStatusList()));
    }

    public void inputWords() {
        System.out.println("정답을 입력해 주세요.");
    }

    public void errors(final Exception e) {
        System.out.println(e.getMessage());
    }
}
