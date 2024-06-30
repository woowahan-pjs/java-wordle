package wordle.model;

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

        Letters answerLetters = wordLoader.getAnswer();

        int tryCount = 0;
        while (tryCount++ < TRY_COUNT_LIMIT) {
            Letters inputLetters = getInputLetters();
            Tiles tiles = tileService.create(answerLetters, inputLetters);

            if (isEnd(tiles, tryCount)) {
                break;
            }

            console.printTiles(tileService.findAll());
        }
    }

    private Letters getInputLetters() {
        while (true) {
            console.printInputRequestMessage();

            String input = console.inputAnswer();
            if (isInputLettersInvalid(input)) {
                continue;
            }

            return new Letters(input);
        }
    }

    private boolean isInputLettersInvalid(String input) {
        if (wordleValidator.isInvalidLength(input)) {
            console.printInvalidLengthMessage();
            return true;
        }

        if (wordLoader.isNotIncludedWord(input)) {
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
