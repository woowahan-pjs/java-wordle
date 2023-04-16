package woowaapplication.pair.game.wordle;

import java.util.Scanner;

import woowaapplication.pair.game.util.KeywordValidator;
import woowaapplication.pair.game.wordle.domain.Coin;
import woowaapplication.pair.game.wordle.domain.WordleBlock;
import woowaapplication.pair.game.wordle.dto.GameResultDto;
import woowaapplication.pair.game.wordle.exception.InvalidAnswerKeywordException;
import woowaapplication.pair.game.wordle.exception.InvalidInputKeywordException;
import woowaapplication.pair.game.wordle.exception.OutOfChanceException;
import woowaapplication.pair.game.wordle.exception.ReadFileException;

public class WordleGame {
    public static final int TOTAL_CHANCE = 6;

    public static final int KEYWORD_LENGTH = 5;

private final WordleGameStorage wordleGameStorage;

    private final WordleGameUI wordleGameUI;

    public WordleGame() {
        Coin coin = Coin.of(this.TOTAL_CHANCE);
        this.wordleGameStorage = WordleGameStorage.of(coin);
        this.wordleGameUI = WordleGameUI.of();
    }

    public static WordleGame of() {
        return new WordleGame();
    }

    public void start() {
        Scanner sc = ready();

        while (!wordleGameStorage.isGameEnd()) {
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
        String answerKeyword = WordleGameAnswerGenerator.getAnswerKeyword();

        GameResultDto gameResultDto = playRound(inputKeyword, answerKeyword);

        wordleGameUI.printResult(gameResultDto);
    }

    public GameResultDto playRound(String inputKeyword, String answerKeyword) {
        WordleBlock[] wordleBlocks = WordleBlock.from(inputKeyword, answerKeyword);

        wordleGameStorage.submit(wordleBlocks);

        return GameResultDto.of(
            wordleGameStorage.convertHistoryToEmoji(),
            TOTAL_CHANCE,
            wordleGameStorage.getRestChance(),
            wordleGameStorage.isGameClear()
        );
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
