package com.wodle.domain;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AnswerWord extends Word {

    private boolean[] alphabetExistInfoStore = new boolean[26];

    public AnswerWord(String word) {
        super(word);
        Arrays.fill(alphabetExistInfoStore, false);

        char[] words = word.toCharArray();

        for (char c : words) {
            alphabetExistInfoStore[c - 'a'] = true;
        }
    }

    public Result compare(Word target) {
        char[] sourceWordArray = this.getWordArray();
        char[] targetWordArray = target.getWordArray();
        List<TileColor> matchResult = new LinkedList<>();

        for (int i = 0; i < sourceWordArray.length; i++) {
            matchResult.add(match(sourceWordArray, targetWordArray, i));
        }

        return new Result(matchResult);
    }

    private TileColor match(char[] source, char[] target, int index) {
        if (source[index] == target[index]) {
            return TileColor.GREEN;
        }

        if (alphabetExistInfoStore[target[index] - 'a']) {
            return TileColor.YELLOW;
        }

        return TileColor.GREY;
    }
}
