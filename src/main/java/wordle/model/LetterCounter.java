package wordle.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCounter {

    private final Map<Character, Integer> letterCountMap;

    public LetterCounter(Letters letters) {
        this.letterCountMap = new HashMap<>();
        for (Letter answerLetter : letters) {
            char value = answerLetter.getValue();
            letterCountMap.put(value, letterCountMap.getOrDefault(value, 0) + 1);
        }
    }

    public void decreaseCount(Letters letters) {
        for (Letter letter : letters) {
            char value = letter.getValue();
            letterCountMap.put(value, letterCountMap.get(value) - 1);
        }
    }

    public void decreaseCount(Letter letter) {
        char value = letter.getValue();
        letterCountMap.put(value, letterCountMap.get(value) - 1);
    }

    public Letters filterCanDecreaseCount(Letters letters) {
        List<Letter> filteredLetters = letters.stream()
                .filter(this::canDecreaseCount)
                .toList();

        return new Letters(filteredLetters);
    }

    public boolean canDecreaseCount(Letter letter) {
        char value = letter.getValue();
        return letterCountMap.containsKey(value) && letterCountMap.get(value) > 0;
    }

    public Letters filterCanNotDecreaseCount(Letters letters) {
        List<Letter> filteredLetters = letters.stream()
                .filter(this::canNotDecreaseCount)
                .toList();

        return new Letters(filteredLetters);
    }

    public boolean canNotDecreaseCount(Letter letter) {
        return !canDecreaseCount(letter);
    }
}
