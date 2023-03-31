package com.wodle.controller;

import com.wodle.domain.AnswerWord;
import com.wodle.domain.Coins;
import com.wodle.domain.Result;
import com.wodle.domain.Word;
import com.wodle.service.InputManager;
import com.wodle.service.ViewManager;
import com.wodle.service.WordsGenerator;

public class GameHost {

    private static final int START_COIN = 6;
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
        Coins coins = new Coins(START_COIN);
        boolean isGameEnd = false;

        viewManager.printGameStart();

        while (!coins.isEmpty() && !isGameEnd) {
            coins.use();
            Word inputWord = inputManager.inputWord();
            Result wordCompareResult = word.compare(inputWord);
            viewManager.printCompareResult(wordCompareResult);

            isGameEnd = wordCompareResult.isGameEnd();
        }

        viewManager.printResult(isGameEnd, word);
    }

}
