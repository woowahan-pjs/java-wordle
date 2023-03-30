package com.wodle.controller;

import com.wodle.domain.AnswerWord;
import com.wodle.domain.Result;
import com.wodle.domain.Word;
import com.wodle.service.InputManager;
import com.wodle.service.ViewManager;
import com.wodle.service.WordsGenerator;

public class GameHost {

    private final InputManager inputManager;

    private final ViewManager viewManager;

    private final WordsGenerator wordsGenerator;

    public GameHost(InputManager inputManager, ViewManager viewManager,
        WordsGenerator wordsGenerator) {
        this.inputManager = inputManager;
        this.viewManager = viewManager;
        this.wordsGenerator = wordsGenerator;
    }

    public void play() {
        AnswerWord word = wordsGenerator.getTodayWord();
        boolean isGameEnd = false;

        viewManager.printGameStart();

        for (int i = 0; i < 6 && !isGameEnd; i++) {
            Word inputWord = getInputWord();
            Result wordCompareResult = word.compare(inputWord);
            viewManager.printCompareResult(wordCompareResult);

            isGameEnd = wordCompareResult.isGameEnd();
        }

        viewManager.printResult(isGameEnd, word);
    }

    private Word getInputWord() {
        try {
            viewManager.printRequestWordInput();
            return inputManager.inputWord();
        } catch (Exception e) {
            viewManager.notifyInvalidInputWord();
            return getInputWord();
        }

    }
}
