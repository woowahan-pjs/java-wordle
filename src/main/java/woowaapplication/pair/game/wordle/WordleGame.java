package woowaapplication.pair.game.wordle;

import java.util.List;
import java.util.Scanner;

import woowaapplication.pair.game.wordle.domain.Coin;
import woowaapplication.pair.game.wordle.dto.GameResultDto;
import woowaapplication.pair.game.wordle.exception.InvalidAnswerKeywordException;
import woowaapplication.pair.game.wordle.exception.InvalidInputKeywordException;
import woowaapplication.pair.game.wordle.exception.OutOfChanceException;
import woowaapplication.pair.game.wordle.exception.ReadFileException;

public class WordleGame {

    public static final int KEYWORD_LENGTH = 5;
    private final WordleGameService wordleGameService;
    private final WordleGameUI wordleGameUI;

    public WordleGame() {
        Coin coin = Coin.of(WordleGameService.TOTAL_CHANCE);
        WordleGameStorage wordleGameStorage = WordleGameStorage.of(coin);
        this.wordleGameUI = WordleGameUI.of();
        this.wordleGameService = WordleGameService.of(wordleGameStorage);
    }

    public void start() {
        Scanner sc = ready();

        while (!wordleGameService.isGameEnd()) {
            try {
                run(sc);
            } catch (InvalidInputKeywordException e) {
                System.out.println(e.getMessage());
            } catch (InvalidAnswerKeywordException e) {
                System.out.println(e.getMessage());
                break;
            } catch (ReadFileException e) {
                System.out.println(e.getMessage());
                break;
            } catch (OutOfChanceException e) {
                System.out.println(e.getMessage());
                break;
            }
        }

        terminate();
    }

    private void run(Scanner sc) {
        String inputKeyword = sc.nextLine();

        KeywordValidator.validate(inputKeyword, KEYWORD_LENGTH);
        GameResultDto gameResultDto = wordleGameService.playRound(inputKeyword);

        wordleGameUI.printResult(gameResultDto);

    }

    private Scanner ready() {
        Scanner sc = new Scanner(System.in);
        WordleGameUI.printReady();

        return sc;
    }

    private void terminate() {
        WordleGameUI.printTerminate();
    }
}
