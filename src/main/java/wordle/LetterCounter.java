package wordle;

import java.util.HashMap;
import java.util.List;
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

    public void decreaseCount(Letters letters) {
        for (Letter letter : letters.getLetters()) {
            letterCountMap.put(letter, letterCountMap.get(letter) - 1);
        }
    }

    public boolean canDecreaseCount(Letter inputLetter) {
        return letterCountMap.containsKey(inputLetter) && letterCountMap.get(inputLetter) > 0;
    }

    public boolean canNotDecreaseCount(Letter inputLetter) {
        return letterCountMap.containsKey(inputLetter) && letterCountMap.get(inputLetter) <= 0;
    }

    public Letters filterCanDecreaseCount(Letters letters) {
        List<Letter> filteredLetters = letters.getLetters()
                .stream()
                .filter(this::canDecreaseCount)
                .toList();

        return new Letters(filteredLetters);
    }
}
