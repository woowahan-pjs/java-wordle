package woowaapplication.pair.game.wordle;

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

    private String answerKeyword;

private final WordleGameStorage wordleGameStorage;

    private final WordleGameIO wordleGameIO;

    public WordleGame() {
        Coin coin = Coin.of(this.TOTAL_CHANCE);
        this.wordleGameStorage = WordleGameStorage.of(coin);
        this.wordleGameIO = WordleGameIO.of();
    }

    public static WordleGame of() {
        return new WordleGame();
    }

    public void start() {
        ready();

        while (!wordleGameStorage.isGameEnd()) {
            try {
                run();
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

    private void run() {
        String inputKeyword = WordleGameIO.printInputKeyword();

        KeywordValidator.validate(inputKeyword, KEYWORD_LENGTH);

        GameResultDto gameResultDto = playRound(inputKeyword, answerKeyword);

        wordleGameIO.printResult(gameResultDto);
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

    private void ready() {
        WordleGameIO.printReady();

        answerKeyword = WordleGameAnswerGenerator.getAnswerKeyword();
    }

    private void terminate() {
        WordleGameIO.printTerminate();
    }
}
