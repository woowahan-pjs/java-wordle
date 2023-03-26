package com.wodle.domain;


import static com.wodle.utils.StringUtils.matchesFiveSmallAlphabet;

public class Word {

    private final String word;

    public Word(String word) {
        validate(word);
        this.word = word;
    }

    private void validate(String word) {
        if (!matchesFiveSmallAlphabet(word)) {
            throw new IllegalArgumentException("user input require 5 small alphabet");
        }
    }

    protected char[] getWordArray() {
        return word.toCharArray();
    }

    public String getWord() {
        return word;
    }
}
