package wordle;

import java.time.LocalDate;
import java.util.List;

public class Wordle {

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
        Words words = new Words(wordList, LocalDate.of(2021, 6, 19));
        LocalDate now = LocalDate.now();
        String wordOfDay = words.getWordOfDay(now);

        Letters answerLetters = new Letters(wordOfDay);
        LetterCounter letterCounter = new LetterCounter(answerLetters);

        TileHistory tileHistory = new TileHistory();
        int tryCount = 0;
        while (tryCount < 6) {
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
            Result result = checkContainsValue(answerLetters, inputLetters, letterCounter);

            String tile = result.toString();
            tileHistory.add(tile);

            // 정답이면 탈출, 6번 초과 실패
            if (ANSWER_TILE.equals(tile)) {
                // 정답 여부만 체크
                ioView.printTryCount(tryCount + 1, 6);
                ioView.printHistories(tileHistory);
                break;
            }

            if (tryCount == 5) {
                ioView.printTryCount("X", 6);
                ioView.printHistories(tileHistory);
                break;
            }

            ioView.printHistories(tileHistory);

            tryCount++;
        }
    }

    private Result checkContainsValue(Letters answerLetters, Letters inputLetters, LetterCounter letterCounter) {
        Result result = new Result(5);

        // 초록색 타일
        Letters samePositionAndValueLetters = answerLetters.findSamePositionAndValueLetters(inputLetters);
        letterCounter.decreaseCount(samePositionAndValueLetters);
        result.addGreenTile(samePositionAndValueLetters);

        // 노란색 타일
        Letters sameValueLetters = answerLetters.findSameValueLetters(inputLetters);
        Letters filteredSameValueLetters = letterCounter.filterCanDecreaseCount(sameValueLetters);
        result.addYellowTile(filteredSameValueLetters);

        // 회색 타일

        return null;
    }

    private Result checkContainsValue(Answer answer, List<Letter> inputLetters) {
        Result result = new Result(5);

        for (Letter inputLetter : inputLetters) {
            if (answer.equalsPositionAndValue(inputLetter)) {
                answer.decreaseCount(inputLetter);
                result.addGreenTile(inputLetter.getPosition());
            }
        }

        for (Letter inputLetter : inputLetters) {
            if (answer.canDecreaseCount(inputLetter)) {
                answer.decreaseCount(inputLetter);
                result.addYellowTile(inputLetter.getPosition());
            } else if (answer.canNotDecreaseCount(inputLetter)) {
                if (result.isNullOrNotGreenTile(inputLetter.getPosition())) {
                    result.addGrayTile(inputLetter.getPosition());
                }
            } else {
                result.addGrayTile(inputLetter.getPosition());
            }
        }

        return result;
    }
}
