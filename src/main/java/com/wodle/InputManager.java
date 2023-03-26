package com.wodle;

import static com.wodle.utils.StringUtils.matchesFiveSmallAlphabet;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class InputManager {

    public Word inputWord() {
        try {
            String userInput = Console.readLine();
            validate(userInput);
            return new Word(userInput);
        } catch (IllegalArgumentException e) {
            return this.inputWord();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("No such line");
        }
    }

    private void validate(String userInput) {
        if (!matchesFiveSmallAlphabet(userInput)) {
            throw new IllegalArgumentException("user input require 5 small alphabet");
        }
    }
}