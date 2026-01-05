package wordle.model;

import java.util.List;

public class LetterComparator {

    private final ResultStorage resultStorage;

    public LetterComparator(ResultStorage resultStorage) {
        this.resultStorage = resultStorage;
    }

    public Result compare(Letters answerLetters, Letters inputLetters) {
        LetterCounter letterCounter = new LetterCounter(answerLetters);
        Result result = new Result(answerLetters.size());

        processSamePositionAndValueLetters(answerLetters, inputLetters, letterCounter, result);
        processSameValueLetters(answerLetters, inputLetters, letterCounter, result);
        processNoneMatchLetters(answerLetters, inputLetters, result);

        resultStorage.add(result);
        return result;
    }

    private void processSamePositionAndValueLetters(Letters answerLetters, Letters inputLetters, LetterCounter letterCounter, Result result) {
        Letters samePositionAndValueLetters = inputLetters.findSamePositionAndValueLetters(answerLetters);
        letterCounter.decreaseCount(samePositionAndValueLetters);
        result.addGreenTile(samePositionAndValueLetters);
    }

    private void processSameValueLetters(Letters answerLetters, Letters inputLetters, LetterCounter letterCounter, Result result) {
        Letters sameValueLetters = inputLetters.findSameValueLetters(answerLetters);
        Letters sameValueLettersForGrayTile = letterCounter.filterCanNotDecreaseCount(sameValueLetters);
        result.addGrayTile(sameValueLettersForGrayTile);

        Letters sameValueLettersForYellowTile = letterCounter.filterCanDecreaseCount(sameValueLetters);
        letterCounter.decreaseCount(sameValueLettersForYellowTile);
        result.addYellowTile(sameValueLettersForYellowTile);
    }

    private void processNoneMatchLetters(Letters answerLetters, Letters inputLetters, Result result) {
        Letters noneMatchingLetters = inputLetters.findNoneMatchingLetters(answerLetters);
        result.addGrayTile(noneMatchingLetters);
    }

    public List<Result> getAllResults() {
        return resultStorage.findAll();
    }
}
