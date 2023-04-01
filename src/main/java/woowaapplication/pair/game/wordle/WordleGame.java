package woowaapplication.pair.game.wordle;

import java.util.List;
import java.util.Scanner;
import woowaapplication.pair.game.wordle.exception.InvalidAnswerKeywordException;
import woowaapplication.pair.game.wordle.exception.InvalidInputKeywordException;
import woowaapplication.pair.game.wordle.exception.ReadFileException;

public class WordleGame {

    public static final int TOTAL_CHANCE = 6;
    public static final int KEYWORD_LENGTH = 5;
    private final WordleGameService wordleGameService;
    private final WordleGameUI wordleGameUI;

    public WordleGame() {
        Coin coin = new Coin(TOTAL_CHANCE);
        WordleGameStorage wordleGameStorage = new WordleGameStorage(coin);
        this.wordleGameUI = new WordleGameUI(wordleGameStorage);
        this.wordleGameService = new WordleGameService(wordleGameStorage);
    }

    public void start() {
        Scanner sc = ready();

        while (!wordleGameService.isGameOver()) {
            try {
                run(sc);
            } catch (InvalidInputKeywordException e) {
                System.out.println("올바른 입력이 아닙니다. 다시 시도해주세요.");
            } catch (InvalidAnswerKeywordException e) {
                System.out.println("오늘의 정답 키워드가 유효하지 않습니다. 관리자에게 문의해주세요.");
                break;
            } catch (ReadFileException e) {
                System.out.println("파일을 읽는데 실패했습니다. 관리자에게 문의해주세요.");
                break;
            }
        }

        terminate();
    }

    private void run(Scanner sc) {
        String inputKeyword = sc.nextLine();

        KeywordValidator.validate(inputKeyword, KEYWORD_LENGTH);
        List<String[]> 게임_결과 = wordleGameService.playRound(inputKeyword);

        wordleGameUI.printResult(게임_결과);
    }

    private Scanner ready() {
        // 인트로 출력
        Scanner sc = new Scanner(System.in);
        System.out.println("WORDLE을 6번 만에 맞춰 보세요.");
        System.out.println("시도의 결과는 타일의 색 변화로 나타납니다.");

        return sc;
    }

    private void terminate() {
        System.out.println("게임이 종료되었습니다.");
    }
}
