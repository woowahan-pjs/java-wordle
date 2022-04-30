package wordle;

import java.io.IOException;
import wordle.ui.InputView;
import wordle.ui.ResultView;

public class WordleGameRunner {
    private static final int VALID_WORD_LENGTH = 5;

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void run() throws IOException {
        // 게임 시작
        printGameStart();

        // 입력 받기 > 유효성 검사 (5글자)
        final String givenWord = inputUsersWord();

        // words.txt 파일 읽은 후 정답 추출

        // 비교

        // 결과 출력
    }

    private void printGameStart() {
        resultView.printGameStart();
    }

    private String inputUsersWord() {
        resultView.printInputWord();

        do {
            final String givenWord = inputView.inputUsersWord();

            if (validateLength(givenWord)) {
                return givenWord;
            }

            resultView.printRetryInputWord();
            resultView.printInputWord();
        } while (true);
    }

    private boolean validateLength(String word) {
        return word.length() == VALID_WORD_LENGTH;
    }
}
