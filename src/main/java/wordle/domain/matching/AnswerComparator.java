package wordle.domain.matching;

import java.util.HashMap;
import java.util.Map;

public class AnswerComparator {

    public MatchResult[] compare(String inputValue, String answerValue) {
        int length = answerValue.length();
        MatchResult[] results = new MatchResult[length];

        Map<Character, Integer> remainingChars = makeLetterCount(answerValue);

        checkGreen(inputValue, answerValue, results, remainingChars);
        checkYellowAndGray(inputValue, results, remainingChars);

        return results;
    }

    private void checkGreen(String input, String answer, MatchResult[] results,
            Map<Character, Integer> remainingChars) {
        for (int i = 0; i < input.length(); i++) {
            char inputChar = Character.toLowerCase(input.charAt(i));
            char answerChar = Character.toLowerCase(answer.charAt(i));

            if (inputChar == answerChar) {
                results[i] = MatchResult.GREEN;
                minusLetterCount(remainingChars, inputChar);
            }
        }
    }

    private void checkYellowAndGray(String input, MatchResult[] results,
            Map<Character, Integer> remainingChars) {
        for (int i = 0; i < input.length(); i++) {
            if (results[i] != null) {
                continue;
            }

            char inputChar = Character.toLowerCase(input.charAt(i));
            int remainingCount = remainingChars.getOrDefault(inputChar, 0);

            if (remainingCount > 0) {
                results[i] = MatchResult.YELLOW;
                minusLetterCount(remainingChars, inputChar);
            } else {
                results[i] = MatchResult.GRAY;
            }
        }
    }

    private Map<Character, Integer> makeLetterCount(String text) {
        Map<Character, Integer> charCounts = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            char c = Character.toLowerCase(text.charAt(i));
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }

        return charCounts;
    }

    private void minusLetterCount(Map<Character, Integer> charCounts, char c) {
        charCounts.put(c, charCounts.get(c) - 1);
    }
}
