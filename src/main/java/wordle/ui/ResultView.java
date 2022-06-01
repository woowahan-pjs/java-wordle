package wordle.ui;

import wordle.domain.BingoRecord;

import java.util.List;

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

    public void printEmptyLine() {
        System.out.println();
    }

    public void printBingoRecords(List<BingoRecord> bingoRecords) {
        for (BingoRecord record: bingoRecords) {
            System.out.println(record.toPrintFormat());
        }
    }

    public void printTurnAndLimitTryToBingo(int turn, int limitTryToBingo) {
        System.out.printf("%d/%d\n\n", turn, limitTryToBingo);
    }

    public void printInputErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
