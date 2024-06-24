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
    public void showRecord(final Record record) {
        for (final Results results : record) {
            showResults(results);
            System.out.println();
        }
        System.out.println();
    }

    private void showResults(final Results results) {
        results.forEach(result -> System.out.print(findTile(result)));
    }

    private String findTile(final Result result) {
        if (result.isGreen()) {
            return "🟩";
        }
        if (result.isYellow()) {
            return "🟨";
        }
        return "⬜";
    }

    @Override
    public void successEnd(final Record record) {
        System.out.printf("\n%d/%d\n\n", record.size(), Record.MAX_COUNT);
        showRecord(record);
    }

    @Override
    public void failEnd(final Record record) {
        System.out.printf("\nX/%d\n\n", Record.MAX_COUNT);
        showRecord(record);
    }

    @Override
    public void wrongAnswer() {
        System.out.println("올바르지 않은 단어입니다.");
    }

    @Override
    public void unexpectedEnd() {
        System.out.println("비정상적으로 게임이 종료되었습니다.");
    }
}
