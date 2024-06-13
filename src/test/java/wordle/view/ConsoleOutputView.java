package wordle.view;

import wordle.domain.Results;

import java.util.stream.Collectors;

public class ConsoleOutputView implements OutputView {

    private static final String WELCOME_MESSAGE = "WORDLE을 %s번 만에 맞춰 보세요.";
    private static final String RESULT_DESCRIPTION_MESSAGE = "시도의 결과는 타일의 색 변화로 나타납니다.";
    public static final String INSERT_ANSWER_MESSAGE = "정답을 입력해 주세요.";
    public static final String WRONG_WORD_MESSAGE = "단어가 올바르지 않습니다.";

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
    public void showResults(final Results results, final int attempt, final int maxAttempt) {
        if (results.hasAnswer() || attempt == maxAttempt) {
            System.out.println("%s/%s".formatted(results.size(), maxAttempt));
        }

        final String resultSentence = results.getResults().stream()
                .map(it -> it.getResult().stream()
                        .map(ResultColor::color)
                        .collect(Collectors.joining())
                ).collect(Collectors.joining("\n"));

        System.out.println(resultSentence);
    }

    @Override
    public void insertedWord(final String wordString) {
        System.out.println(wordString);
    }
}