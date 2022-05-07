package wordle.game.wordle;

import wordle.domain.MatchResults;

final class WordleView {

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

    void errors(final Exception e) {
        System.out.println(e.getMessage());
    }
}
