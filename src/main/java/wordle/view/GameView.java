package wordle.view;

import wordle.domain.GameRecord;
import wordle.domain.GameRecords;
import wordle.domain.Round;

public class GameView {

    public void initialize() {
        System.out.println("WORDLE을 6번 만에 맞춰 보세요.\n시도의 결과는 타일의 색 변화로 나타납니다.");
    }

    public void inputAnswer() {
        System.out.println("정답을 입력해 주세요.");
    }

    public void showGameResult(GameRecords gameRecords) {
        System.out.println(gameRecords);
    }

    public void printRound(Round round) {
        System.out.println(round);
    }

    // result
    public void printRecords(GameRecords gameRecords) {
//        gameRecords.getRecords().stream()
//            .map(GameRecord::getResults)
//            .forEach(System.out::print);


    }
}
