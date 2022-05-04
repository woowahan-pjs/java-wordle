package wordle.ui;

import java.util.List;
import wordle.domain.BingoHistory;

public class ResultView {

    public void printGameStart() {
        System.out.println("WORDLE을 6번 만에 맞춰 보세요.");
        System.out.println("시도의 결과는 타일의 색 변화로 나타납니다.");
    }

    public void printInputWord() {
        System.out.println("정답을 입력해 주세요.");
    }

    public void printRetryInputWord() {
        System.out.println("잘못된 글자 수 입니다. 5글자로 입력해 주세요.");
    }

    public void printGameResult(List<BingoHistory> history, boolean isContinue) {
        System.out.println();
        printFinalResult(history, isContinue);
        for (BingoHistory bingoHistory : history) {
            bingoHistory.getHistory().stream().map(x -> x.printFormat).forEach(System.out::print);
            System.out.println();
        }
        System.out.println();
    }

    private void printFinalResult(List<BingoHistory> history, boolean isContinue) {
        if (isContinue == false) {
            System.out.println(history.size() + "/6");
            System.out.println();
        }
    }
}
