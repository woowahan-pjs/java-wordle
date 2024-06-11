package wordle;

import java.util.HashMap;
import java.util.Map;

public class Answer {

    private final char[] answerArr;
    private final Map<Character, Integer> counterMap;

    public Answer(char[] answerArr) {
        this.answerArr = answerArr;
        this.counterMap = new HashMap<>();
        for (char answerChar : answerArr) {
            counterMap.put(answerChar, counterMap.getOrDefault(answerChar, 0) + 1);
        }
    }

    public void decreaseCount(char c) {
        counterMap.put(c, counterMap.get(c) - 1);
    }

    public boolean canDecreaseCount(char c) {
        return counterMap.containsKey(c) && counterMap.get(c) > 0;
    }

    public boolean canNotDecreaseCount(char c) {
        return counterMap.containsKey(c) && counterMap.get(c) <= 0;
    }

    public boolean equalsPositionAndCharacter(int index, char c) {
        return answerArr[index] == c;
    }
}
