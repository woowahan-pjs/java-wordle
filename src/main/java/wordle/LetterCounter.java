package wordle;

import java.util.HashMap;
import java.util.Map;

public class LetterCounter {
    private final Map<Letter, Integer> letterCountMap;

    public LetterCounter(Letters letters) {
        this.letterCountMap = new HashMap<>();
        for (Letter answerLetter : letters.getLetters()) {
            letterCountMap.put(answerLetter, letterCountMap.getOrDefault(answerLetter, 0) + 1);
        }
    }

    public void decreaseCount(Letter inputLetter) {
        letterCountMap.put(inputLetter, letterCountMap.get(inputLetter) - 1);
    }

    public boolean canDecreaseCount(Letter inputLetter) {
        return letterCountMap.containsKey(inputLetter) && letterCountMap.get(inputLetter) > 0;
    }

    public boolean canNotDecreaseCount(Letter inputLetter) {
        return letterCountMap.containsKey(inputLetter) && letterCountMap.get(inputLetter) <= 0;
    }
}
