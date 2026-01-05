package wordle.model;

import wordle.view.Console;

public class Wordle {

    private static final int TRY_COUNT_LIMIT = 6;

    private final Console console;
    private final WordLoader wordLoader;
    private final WordleValidator wordleValidator;
    private final LetterComparator letterComparator;

    public Wordle(Console console, WordLoader wordLoader, WordleValidator wordleValidator, LetterComparator letterComparator) {
        this.console = console;
        this.wordLoader = wordLoader;
        this.wordleValidator = wordleValidator;
        this.letterComparator = letterComparator;
    }

    public void start() {
        console.printInitGameMessage();

        Letters answerLetters = wordLoader.getAnswer();

        int tryCount = 0;
        while (tryCount++ < TRY_COUNT_LIMIT) {
            Letters inputLetters = getInputLetters();
            Result result = letterComparator.compare(answerLetters, inputLetters);

            if (isEnd(result, tryCount)) {
                break;
            }

            console.printResults(letterComparator.getAllResults());
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

    private boolean isEnd(Result result, int tryCount) {
        if (result.isAnswer()) {
            console.printResults(tryCount, TRY_COUNT_LIMIT, letterComparator.getAllResults());
            return true;
        }

        if (tryCount == TRY_COUNT_LIMIT) {
            console.printResults(TRY_COUNT_LIMIT, letterComparator.getAllResults());
            return true;
        }

        return false;
    }
}
