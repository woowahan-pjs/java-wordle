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
        GameMachine machine = init();

        viewManager.printGameStart();

        while (machine.isGameNotEnd()) {
            machine.useCoin();
            Word inputWord = inputManager.inputWord();
            Result wordCompareResult = machine.compareWord(inputWord);
            viewManager.printCompareResult(wordCompareResult);

            machine.isGameEnd = wordCompareResult.isGameEnd();
        }

        viewManager.printResult(machine.isGameEnd, machine.word);
    }

    private GameMachine init(){
        AnswerWord word = wordsGenerator.getTodayWord();
        return new GameMachine(word, START_COIN);
    }

    private static class GameMachine {
        private final AnswerWord word;
        private final Coins coins;
        private boolean isGameEnd = false;

        public GameMachine(AnswerWord word, int startCoin){
            this.word = word;
            this.coins = new Coins(startCoin);
        }

        public boolean isGameNotEnd (){
            return !coins.isEmpty() && !isGameEnd;
        }

        public void useCoin(){
            coins.use();
        }

        public Result compareWord(Word inputWord){
            return this.word.compare(inputWord);
        }
    }

}
