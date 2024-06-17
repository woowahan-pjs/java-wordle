package wordle;

import java.time.LocalDate;

public class Wordle {

    private static final int TRY_COUNT_LIMIT = 6;

    private final Console console;
    private final WordService wordService;
    private final WordleValidator wordleValidator;
    private final TileService tileService;

    public Wordle(Console console, WordService wordService, WordleValidator wordleValidator, TileService tileService) {
        this.console = console;
        this.wordService = wordService;
        this.wordleValidator = wordleValidator;
        this.tileService = tileService;
    }

    public void start() {
        console.printInitGameMessage();

        Words words = wordService.getWords();
        String wordOfDay = words.getWordOfDay(LocalDate.now());
        Letters answerLetters = new Letters(wordOfDay);

        int tryCount = 0;
        while (tryCount < TRY_COUNT_LIMIT) {
            tryCount++;

            Letters inputLetters = getInputLetters(words);
            Tiles tiles = tileService.create(answerLetters, inputLetters);

            if (tileService.isAnswer(tiles)) {
                console.printResult(tryCount, TRY_COUNT_LIMIT, tileService.findAll());
                break;
            }

            if (tryCount == TRY_COUNT_LIMIT) {
                console.printResult(TRY_COUNT_LIMIT, tileService.findAll());
                break;
            }

            console.printTiles(tileService.findAll());
        }
    }

    private Letters getInputLetters(Words words) {
        Letters inputLetters;
        while (true) {
            console.printInputRequestMessage();
            String input = console.inputAnswer();
            inputLetters = new Letters(input);

            if (wordleValidator.isInvalidLength(inputLetters)) {
                console.printInvalidLengthMessage();
                continue;
            }

            if (wordleValidator.isNotIncludedWord(inputLetters, words)) {
                console.printNotInWordListMessage();
                continue;
            }

            break;
        }
        return inputLetters;
    }
}
