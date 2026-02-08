package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordComparator {

    public WordResult compare(String input, String answer) {

        Map<Character, Integer> answerCharCountMap = createWordCharCountMap(answer);

        boolean[] isPerfectMatched = new boolean[input.length()];
        List<Integer> perfectIndexes = getPerfectMatchedIndexes(input, answer, answerCharCountMap, isPerfectMatched);
        List<Integer> partialIndexes = getPartialMatchedIndexes(input, answerCharCountMap, isPerfectMatched);

        return new WordResult(answer.length(), partialIndexes, perfectIndexes);
    }

    private Map<Character, Integer> createWordCharCountMap(String answer) {

        Map<Character, Integer> answerCharCountMap = new HashMap<>();

        for (char c : answer.toCharArray()) {
            answerCharCountMap.put(c, answerCharCountMap.getOrDefault(c, 0) + 1);
        }

        return answerCharCountMap;
    }

    private List<Integer> getPerfectMatchedIndexes(String inputWord, String answer, Map<Character, Integer> answerCharCountMap, boolean[] isPerfectMatched) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < inputWord.length(); i++) {
            if (inputWord.charAt(i) == answer.charAt(i)) {
                list.add(i);
                isPerfectMatched[i] = true;
                answerCharCountMap.put(inputWord.charAt(i), answerCharCountMap.get(inputWord.charAt(i)) - 1);
                removeIfZeroCount(answerCharCountMap, inputWord.charAt(i));
            }
        }

        return list;
    }

    private List<Integer> getPartialMatchedIndexes(String inputWord, Map<Character, Integer> answerCharCountMap, boolean[] isPerfectMatched) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < inputWord.length(); i++) {
            if (isPerfectMatched[i]) continue;

            if (answerCharCountMap.containsKey(inputWord.charAt(i))) {
                list.add(i);
                answerCharCountMap.put(inputWord.charAt(i), answerCharCountMap.get(inputWord.charAt(i)) - 1);
                removeIfZeroCount(answerCharCountMap, inputWord.charAt(i));
            }
        }

        return list;
    }

    private void removeIfZeroCount(Map<Character, Integer> answerCharCountMap, char key) {
        if (answerCharCountMap.get(key) == 0) {
            answerCharCountMap.remove(key);
        }
    }
}
