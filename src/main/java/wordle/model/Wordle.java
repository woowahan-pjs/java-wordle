package wordle.model;

import java.time.LocalDate;
import wordle.view.Console;

public class Wordle {

    private static final int TRY_COUNT_LIMIT = 6;

    private final Console console;
    private final WordService wordService;
    private final WordleValidator wordleValidator;

    public Wordle(Console console, WordService wordService, WordleValidator wordleValidator) {
        this.console = console;
        this.wordService = wordService;
        this.wordleValidator = wordleValidator;
    }

    public void start() {
        console.printInitGameMessage();

        Words words = wordService.getWords();
        Answer answer = createAnswer(words);
        Results results = new Results();

        int tryCount = 0;
        while (tryCount++ < TRY_COUNT_LIMIT) {
            Letters inputLetters = getInputLetters(words);
            Result result = answer.evaluate(inputLetters);
            results.add(result);

            if (isEnd(results, tryCount)) {
                break;
            }

            console.print(results);
        }
    }

    private Answer createAnswer(Words words) {
        String wordOfDay = words.getWordOfDay(LocalDate.now());
        return new Answer(new Letters(wordOfDay));
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

    private boolean isEnd(Results results, int tryCount) {
        if (results.containsAnswer()) {
            console.printResult(tryCount, TRY_COUNT_LIMIT, results);
            return true;
        }

        if (tryCount == TRY_COUNT_LIMIT) {
            console.printResult(TRY_COUNT_LIMIT, results);
            return true;
        }

        return false;
    }
}
