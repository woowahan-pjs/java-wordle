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
        final String usersWord = inputUsersWord();

        // words.txt 파일 읽기

        // 비교

        // 결과 출력
    }

    private void printGameStart() {
        resultView.printGameStart();
    }

    private String inputUsersWord() {
        resultView.printInputValidWord();

        do {
            final String usersWord = inputView.inputUsersWord();

            if (validateUsersWord(usersWord)) {
                return usersWord;
            }

            resultView.printInvalidWord();
            resultView.printInputValidWord();
        } while (true);
    }

    private boolean validateUsersWord(String usersWord) {
        return usersWord.length() == VALID_WORD_LENGTH;
    }
}
