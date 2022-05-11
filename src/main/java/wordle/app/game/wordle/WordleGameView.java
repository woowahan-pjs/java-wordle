package wordle.app.game.wordle;

import wordle.app.word.domain.MatchResults;

final class WordleGameView {

    void initGame() {
        System.out.println("WORDLE을 6번 만에 맞춰 보세요.\n시도의 결과는 타일의 색 변화로 나타납니다.");
    }

    void round(final Round round) {
        System.out.println(round);
    }

    void wordsMatchResults(final MatchResults matchResults) {
        System.out.println(matchResults);
    }

    void inputWords() {
        System.out.println("정답을 입력해 주세요.");
    }

}
