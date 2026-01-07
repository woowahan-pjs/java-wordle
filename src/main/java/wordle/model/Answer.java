package wordle.model;

import java.util.ArrayList;
import java.util.List;

public class Answer {

    private final Letters letters;

    public Answer(Letters letters) {
        this.letters = letters;
    }

    public Result evaluate(Letters target) {
        Result result = new Result(letters.size());
        LetterCounter letterCounter = new LetterCounter(letters);

        processSamePositionAndValue(target, letterCounter, result);
        processOnlySameValue(target, letterCounter, result);

        return result;
    }

    private void processSamePositionAndValue(Letters target, LetterCounter letterCounter, Result result) {
        Letters samePositionAndValueLetters = target.findSamePositionAndValueLetters(letters);
        letterCounter.decreaseCount(samePositionAndValueLetters);
        result.addGreenTile(samePositionAndValueLetters);
    }

    private void processOnlySameValue(Letters target, LetterCounter letterCounter, Result result) {
        Letters sameValueLetters = target.findSameValueLetters(letters);
        List<Letter> lettersForYellowTile = new ArrayList<>();
        for (Letter letter : sameValueLetters) {
            if (letterCounter.canDecreaseCount(letter)) {
                lettersForYellowTile.add(letter);
                letterCounter.decreaseCount(letter);
            }
        }
        result.addYellowTile(new Letters(lettersForYellowTile));
    }
}
