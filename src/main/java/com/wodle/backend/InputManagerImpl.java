package com.wodle.backend;

import camp.nextstep.edu.missionutils.Console;
import com.wodle.domain.Word;
import java.util.NoSuchElementException;

public class InputManagerImpl implements InputManager{

    public Word inputWord() {
        try {
            String userInput = Console.readLine();
            return new Word(userInput);
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("No such line");
        }
    }
}