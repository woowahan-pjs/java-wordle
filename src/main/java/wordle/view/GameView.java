package wordle.view;

import wordle.domain.GameRecord;
import wordle.domain.GameRecords;
import wordle.domain.Result;

public class GameView {

    public void initialize() {
        System.out.println("WORDLE을 6번 만에 맞춰 보세요.\n시도의 결과는 타일의 색 변화로 나타납니다.");
    }

    public void inputAnswer() {
        System.out.println("정답을 입력해 주세요.");
    }

    public void printRecords(GameRecords gameRecords) {
        System.out.println();

        gameRecords.getRecords().stream()
                .map(GameRecord::getResults)
                .forEach(results -> {
                    for (Result result : results) {
                        System.out.print(result);
                    }
                    System.out.println();
                });

        System.out.println();
        System.out.println();
    }
}
