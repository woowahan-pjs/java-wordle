package wordle;

import java.time.LocalDate;
import java.util.List;

public class Wordle {

    private static final LocalDate CUTOFF_DATE = LocalDate.of(2021, 6, 19);
    private static final int TRY_COUNT_LIMIT = 6;
    private static final String ANSWER_TILE = "\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9";

    private final IOView ioView;
    private final WordsReader wordsReader;
    private final WordleValidator wordleValidator;

    public Wordle(IOView ioView, WordsReader wordsReader, WordleValidator wordleValidator) {
        this.ioView = ioView;
        this.wordsReader = wordsReader;
        this.wordleValidator = wordleValidator;
    }

    public void start() {
        ioView.printInitGameMessage();

        List<String> wordList = wordsReader.read();
        Words words = new Words(wordList, CUTOFF_DATE);
        LocalDate now = LocalDate.now();
//        String wordOfDay = words.getWordOfDay(now);
        String wordOfDay = "apple";

        Letters answerLetters = new Letters(wordOfDay);

        TileHistory tileHistory = new TileHistory();
        int tryCount = 0;
        while (tryCount < TRY_COUNT_LIMIT) {
            tryCount++;

            ioView.printInputAnswerMessage();
            String input = ioView.inputAnswer();

            Letters inputLetters = new Letters(input);
            if (wordleValidator.isInvalidLength(inputLetters)) {
                ioView.printNotEnoughLettersMessage();
                continue;
            }

            if (wordleValidator.isNotIncludedWord(inputLetters, words)) {
                ioView.printNotInWordListMessage();
                continue;
            }

            // Answer vs Input
            Tiles tiles = compareLetters(answerLetters, inputLetters);
            String tile = tiles.toString();
            tileHistory.add(tile);

            // 정답이면 탈출, 6번 초과 실패
            if (ANSWER_TILE.equals(tile)) {
                // 정답 여부만 체크
                ioView.printTryCount(tryCount, TRY_COUNT_LIMIT);
                ioView.printHistories(tileHistory);
                break;
            }

            // 6번째 시도 시 틀렸을 때
            if (tryCount == TRY_COUNT_LIMIT) {
                ioView.printTryCount("X", TRY_COUNT_LIMIT);
                ioView.printHistories(tileHistory);
                break;
            }

            ioView.printHistories(tileHistory);

        }
    }

    public static Tiles compareLetters(Letters answerLetters, Letters inputLetters) {
        LetterCounter letterCounter = new LetterCounter(answerLetters);
        Tiles tiles = new Tiles(answerLetters.size());

        Letters samePositionAndValueLetters = answerLetters.findSamePositionAndValueLetters(inputLetters);
        letterCounter.decreaseCount(samePositionAndValueLetters);
        tiles.addGreenTile(samePositionAndValueLetters);

        Letters sameValueLetters = answerLetters.findSameValueLetters(inputLetters);
        Letters sameValueLettersForGrayTile = letterCounter.filterCanNotDecreaseCount(sameValueLetters);
        tiles.addGrayTile(sameValueLettersForGrayTile);

        Letters sameValueLettersForYellowTile = letterCounter.filterCanDecreaseCount(sameValueLetters);
        letterCounter.decreaseCount(sameValueLettersForYellowTile);
        tiles.addYellowTile(sameValueLettersForYellowTile);

        Letters noneMatchingLetters = answerLetters.findNoneMatchingLetters(inputLetters);
        tiles.addGrayTile(noneMatchingLetters);

        return tiles;
    }
}
