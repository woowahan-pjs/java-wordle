package wordle;

import java.time.LocalDate;
import java.util.List;

public class Wordle {

    private static final LocalDate CUTOFF_DATE = LocalDate.of(2021, 6, 19);
    private static final int TRY_COUNT_LIMIT = 6;

    private final Console console;
    private final WordsReader wordsReader;
    private final WordleValidator wordleValidator;
    private final TileService tileService;

    public Wordle(Console console, WordsReader wordsReader, WordleValidator wordleValidator, TileService tileService) {
        this.console = console;
        this.wordsReader = wordsReader;
        this.wordleValidator = wordleValidator;
        this.tileService = tileService;
    }

    public void start() {
        console.printInitGameMessage();

        List<String> wordList = wordsReader.read();
        Words words = new Words(wordList, CUTOFF_DATE);

        LocalDate now = LocalDate.now();
        String wordOfDay = words.getWordOfDay(now);
        Letters answerLetters = new Letters(wordOfDay);

        int tryCount = 0;
        while (tryCount < TRY_COUNT_LIMIT) {
            tryCount++;

            Letters inputLetters = getInputLetters(words);
            Tiles tiles = tileService.create(answerLetters, inputLetters);

            if (tileService.isAnswer(tiles)) {
                printResult(tryCount);
                break;
            }

            if (tryCount == TRY_COUNT_LIMIT) {
                printResult();
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

    private void printResult(int tryCount) {
        console.printTryCount(tryCount, TRY_COUNT_LIMIT);
        console.printTiles(tileService.findAll());
    }

    private void printResult() {
        console.printTryCount("X", TRY_COUNT_LIMIT);
        console.printTiles(tileService.findAll());
    }
}
