package wordle;

import java.time.LocalDate;
import wordle.domain.BingoHistory;
import wordle.domain.WordFile;
import wordle.domain.Wordle;
import wordle.ui.InputView;
import wordle.ui.ResultView;

public class WordleGameRunner {
    private static final int VALID_WORD_LENGTH = 5;

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void run() {
        // 게임 시작
        printGameStart();

        // words.txt 파일 읽은 후 정답 추출
        final String targetWord = new WordFile("words.txt").findTargetWord(LocalDate.now());

        // New Wordle 생성
        final Wordle wordle = new Wordle(targetWord);

        // 반복
        do {
            /// 입력 받기 > 유효성 검사 (5글자)
            final String givenWord = inputUsersWord();

            /// 비교
            wordle.compare(givenWord);

            /// 결과 출력
            resultView.printGameResult(wordle.getHistory(), wordle.isContinue());
        } while (wordle.isContinue());
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
