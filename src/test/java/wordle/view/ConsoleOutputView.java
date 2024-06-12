package wordle.view;

import wordle.domain.ResultType;
import wordle.domain.Results;

import java.util.stream.Collectors;

public class ConsoleOutputView implements OutputView {

    @Override
    public void welcome(final int maxAttempt) {
        System.out.println("WORDLE을 %s번 만에 맞춰 보세요.".formatted(maxAttempt));
        System.out.println("시도의 결과는 타일의 색 변화로 나타납니다.");
    }

    @Override
    public void insertWord() {
        System.out.println("정답을 입력해 주세요.");
    }

    @Override
    public void wrongWord() {
        System.out.println("단어가 올바르지 않습니다.");
        System.out.println("5글자의 소문자 알파벳으로 다시 입력해 주세요.");
    }

    @Override
    public void showResults(final Results results, final int attempt, final int maxAttempt) {
        if (results.isFinished(attempt)) {
            System.out.println("%s/%s".formatted(results.size(), maxAttempt));
        }

        final String resultSentence = results.getResults().stream()
                .map(it -> it.getResult().stream()
                        .map(ConsoleOutputView::color)
                        .collect(Collectors.joining())
                ).collect(Collectors.joining("\n"));

        System.out.println(resultSentence);
    }

    private static String color(final ResultType resultType) {
        return switch (resultType) {
            case MATCHED -> "🟩";
            case EXIST -> "🟨";
            case MISMATCHED -> "⬜";
        };
    }

    @Override
    public void insertedWord(final String wordString) {
        System.out.println(wordString);
    }
}