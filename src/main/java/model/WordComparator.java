package model;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class WordComparator {

    Map<Character, Integer> map = new HashMap<>();

    public List<Integer> getPerfectMatchedIndex(String inputWord, String todayWord) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < inputWord.length(); i++) {
            if (inputWord.charAt(i) == todayWord.charAt(i)) {
                list.add(i);
            }
        }

        return list;
    }

    public List<Integer> getPartialMatchedIndex(String inputWord, String todayWord) {

        List<Integer> list = new ArrayList<>();

        for (char c : todayWord.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < inputWord.length(); i++) {
            if (!map.containsKey(inputWord.charAt(i))) {
                continue;
            }
            list.add(i);
            int count = map.get(inputWord.charAt(i)) - 1;
            if (count == 0) {
                map.remove(inputWord.charAt(i));
            } else {
                map.put(inputWord.charAt(i), count);
            }
        }

        return list;
    }
}
