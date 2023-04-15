package com.wodle.domain;

public class GameMachine {
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

    public void saveGameStatus(boolean isGameEnd) {
        this.isGameEnd = isGameEnd;
    }

    public AnswerWord getWord() {
        return word;
    }

    public boolean isGameEnd() {
        return isGameEnd;
    }
}