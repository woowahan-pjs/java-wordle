package com.wodle.domain;


import com.wodle.utils.StringUtils;

public class Word {

    private final String word;

    public Word(String word) {
        validate(word);
        this.word = word;
    }

    private void validate(String word) {
        if (!StringUtils.getInstance().matchesFiveSmallAlphabet(word)) {
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
