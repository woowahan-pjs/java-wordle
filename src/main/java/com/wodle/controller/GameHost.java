package com.wodle.controller;

import com.wodle.domain.AnswerWord;
import com.wodle.domain.GameMachine;
import com.wodle.domain.Result;
import com.wodle.domain.Word;
import com.wodle.service.InputManager;
import com.wodle.service.ViewManager;
import com.wodle.service.WordGenerator;
import com.wodle.service.WordGeneratorImpl;

public class GameHost {

    private static final int START_COIN = 6;
    private final InputManager inputManagerProxy;

    private final ViewManager viewManager;

    private final WordGenerator wordGenerator;

    public GameHost(InputManager inputManagerProxy, ViewManager viewManager,
        WordGenerator wordGenerator) {
        this.inputManagerProxy = inputManagerProxy;
        this.viewManager = viewManager;
        this.wordGenerator = wordGenerator;
    }

    public void play() {
        AnswerWord word = wordGenerator.getTodayWord();
        GameMachine machine = new GameMachine(word, START_COIN);

        viewManager.printGameStart();

        while (machine.isGameNotEnd()) {
            machine.useCoin();
            Word inputWord = inputManagerProxy.inputWord();
            Result wordCompareResult = machine.compareWord(inputWord);
            viewManager.printCompareResult(wordCompareResult);

            machine.saveGameStatus(wordCompareResult.isGameEnd());
        }

        viewManager.printResult(machine.isGameEnd(), machine.getWord());
    }

}
