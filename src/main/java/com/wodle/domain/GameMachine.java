package com.wodle.domain;

public class GameMachine {

    private final AnswerWord word;
    private boolean gameEnd = false;

    public GameMachine(AnswerWord word) {
        this.word = word;
    }

    public boolean isGameNotEnd() {
        return !gameEnd;
    }

    public Result compareWord(Word inputWord) {
        Result result = this.word.compare(inputWord);
        this.gameEnd = result.isGameEnd();
        return result;
    }

    public AnswerWord getWord() {
        return word;
    }

    public boolean getGameEnd() {
        return gameEnd;
    }
}