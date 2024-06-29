package wordle.view;

import wordle.domain.Attempt;
import wordle.domain.Result;
import wordle.domain.Results;

import java.util.stream.Collectors;

public class ConsoleOutputView implements OutputView {

    private static final String WELCOME_MESSAGE = "WORDLE을 %s번 만에 맞춰 보세요.";
    private static final String RESULT_DESCRIPTION_MESSAGE = "시도의 결과는 타일의 색 변화로 나타납니다.";
    private static final String INSERT_ANSWER_MESSAGE = "정답을 입력해 주세요.";
    private static final String WRONG_WORD_MESSAGE = "단어가 올바르지 않습니다.";
    private static final String NEW_LINE = "\n";
    private static final String ATTEMPT_RESULT = "%s/%s";

    @Override
    public void welcome(final int maxAttempt) {
        System.out.println(WELCOME_MESSAGE.formatted(maxAttempt));
        System.out.println(RESULT_DESCRIPTION_MESSAGE);
    }

    @Override
    public void insertWord() {
        System.out.println(INSERT_ANSWER_MESSAGE);
    }

    @Override
    public void wrongWord() {
        System.out.println(WRONG_WORD_MESSAGE);
    }

    @Override
    public void showResults(final Results results, final Attempt attempt) {
        if (results.hasAnswer()) {
            System.out.println(ATTEMPT_RESULT.formatted(attempt.current(), attempt.last()));
        }
        final String resultSentence = results.getResults().stream()
                .map(this::color)
                .collect(Collectors.joining(NEW_LINE));
        System.out.println(resultSentence);
    }

    private String color(final Result result) {
        return result.getResult().stream()
                .map(ResultColor::color)
                .collect(Collectors.joining());
    }
}
