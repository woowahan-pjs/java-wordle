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
            for (Result result : results) {
                String s = findTile(result);
                System.out.print(s);
            }
            System.out.println();
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
    public void end(Record record) {
        System.out.printf("%d/%d\n\n", record.size(), Record.MAX_COUNT);
        showRecord(record);
    }
}
