package wordle.model;

import java.time.LocalDate;
import wordle.view.Console;

public class Wordle {

    private static final int TRY_COUNT_LIMIT = 6;

    private final Console console;
    private final WordLoader wordLoader;
    private final WordleValidator wordleValidator;
    private final TileService tileService;

    public Wordle(Console console, WordLoader wordLoader, WordleValidator wordleValidator, TileService tileService) {
        this.console = console;
        this.wordLoader = wordLoader;
        this.wordleValidator = wordleValidator;
        this.tileService = tileService;
    }

    public void start() {
        console.printInitGameMessage();

        Words words = wordLoader.getWords();
        Letters answerLetters = createAnswerLetters(words);

        int tryCount = 0;
        while (tryCount++ < TRY_COUNT_LIMIT) {
            Letters inputLetters = getInputLetters(words);
            Tiles tiles = tileService.create(answerLetters, inputLetters);

            if (isEnd(tiles, tryCount)) {
                break;
            }

            console.printTiles(tileService.findAll());
        }
    }

    private Letters createAnswerLetters(Words words) {
        String wordOfDay = words.getWordOfDay(LocalDate.now());
        return new Letters(wordOfDay);
    }

    private Letters getInputLetters(Words words) {
        Letters inputLetters;
        while (true) {
            console.printInputRequestMessage();
            String input = console.inputAnswer();
            inputLetters = new Letters(input);

            if (isInputLettersInvalid(words, inputLetters)) {
                continue;
            }

            break;
        }
        return inputLetters;
    }

    private boolean isInputLettersInvalid(Words words, Letters inputLetters) {
        if (wordleValidator.isInvalidLength(inputLetters)) {
            console.printInvalidLengthMessage();
            return true;
        }

        if (wordleValidator.isNotIncludedWord(inputLetters, words)) {
            console.printNotInWordListMessage();
            return true;
        }

        return false;
    }

    private boolean isEnd(Tiles tiles, int tryCount) {
        if (tileService.isAnswer(tiles)) {
            console.printResult(tryCount, TRY_COUNT_LIMIT, tileService.findAll());
            return true;
        }

        if (tryCount == TRY_COUNT_LIMIT) {
            console.printResult(TRY_COUNT_LIMIT, tileService.findAll());
            return true;
        }

        return false;
    }
}
