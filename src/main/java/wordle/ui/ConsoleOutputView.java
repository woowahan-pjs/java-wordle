package wordle.ui;

import wordle.domain.Record;
import wordle.domain.Result;
import wordle.domain.Results;

public class ConsoleOutputView implements OutputView {

    @Override
    public void welcome() {
        System.out.printf("WORDLE을 %d번 만에 맞춰 보세요.\n", Record.MAX_COUNT);
        System.out.println("시도의 결과는 타일의 색 변화로 나타납니다.");
    }

    @Override
    public void askAnswer() {
        System.out.println("정답을 입력해 주세요.");
    }

    @Override
    public void showRecord(Record record) {
        for (Results results : record) {
            showResults(results);
            System.out.println();
        }
        System.out.println();
    }

    private static void showResults(Results results) {
        for (Result result : results) {
            System.out.print(findTile(result));
        }
    }

    private static String findTile(Result result) {
        if (result.isGreen()) {
            return "🟩";
        }
        if (result.isYellow()) {
            return "🟨";
        }
        return "⬜";
    }

    @Override
    public void successEnd(Record record) {
        System.out.printf("\n%d/%d\n\n", record.size(), Record.MAX_COUNT);
        showRecord(record);
    }

    @Override
    public void failEnd(Record record) {
        System.out.printf("\nX/%d\n\n", Record.MAX_COUNT);
        showRecord(record);
    }

    @Override
    public void unexpectedEnd(String message) {
        System.out.println(message);
    }
}
