package com.wodle.service;

import com.wodle.backend.InputManager;
import com.wodle.backend.WordGenerator;
import com.wodle.domain.AnswerWord;
import com.wodle.domain.GameMachine;
import com.wodle.domain.Result;
import com.wodle.domain.User;
import com.wodle.domain.Word;
import com.wodle.ui.ViewManager;

public class GameService {

    private static final int START_COIN = 6;
    private final WordGenerator wordGenerator;
    private final ViewManager viewManager;
    private final InputManager inputManagerProxy;

    public GameService(WordGenerator wordGenerator, ViewManager viewManager,
        InputManager inputManagerProxy) {
        this.wordGenerator = wordGenerator;
        this.viewManager = viewManager;
        this.inputManagerProxy = inputManagerProxy;
    }

    public void play() {
        viewManager.printGameStart();

        GameMachine gameMachine = initGameMachine();
        User user = new User(START_COIN);

        while (gameMachine.isGameNotEnd() && user.canPlay()) {
            user.pay();
            Word inputWord = inputManagerProxy.inputWord();
            Result wordCompareResult = gameMachine.compareWord(inputWord);
            viewManager.printCompareResult(wordCompareResult);
        }

        viewManager.printResult(gameMachine.getGameEnd(), gameMachine.getWord());
    }

    private GameMachine initGameMachine() {
        AnswerWord answerWord = wordGenerator.getTodayWord();
        return new GameMachine(answerWord);
    }
}
