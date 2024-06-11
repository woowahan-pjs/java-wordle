package wordle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Answer {

    private final List<Letter> letters;
    private final Map<Letter, Integer> letterCountMap;

    public Answer(String answer) {
        char[] answerArr = answer.toCharArray();

        this.letters = new ArrayList<>();
        for (int i = 0; i < answerArr.length; i++) {
            letters.add(new Letter(i, answerArr[i]));
        }

        this.letterCountMap = new HashMap<>();
        for (Letter answerLetter : letters) {
            letterCountMap.put(answerLetter, letterCountMap.getOrDefault(answerLetter, 0) + 1);
        }
    }

    public boolean equalsPositionAndValue(Letter inputLetter) {
        return letters.contains(inputLetter);
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
