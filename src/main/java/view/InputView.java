package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String START_VIEW = "WORDLE을 6번 만에 맞춰 보세요.";
    private static final String EXPLAIN_VIEW = "시도의 결과는 타일의 색 변화로 나타납니다.";
    private static final String ANSWER_VIEW = "정답을 입력해 주세요.";

    public void startView() {
        System.out.println(START_VIEW);
        System.out.println(EXPLAIN_VIEW);
    }

    public String inputWord() {
        System.out.println(ANSWER_VIEW);
        return Console.readLine();
    }
}
