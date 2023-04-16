package com.wodle.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameMachineTest {

    private GameMachine gameMachine;

    @Test
    @DisplayName("정답단어 비교시 gameEnd가 true로 셋팅")
    public void compareWord_정답() {
        //given
        AnswerWord answerWord = new AnswerWord("answe");
        gameMachine = new GameMachine(answerWord);
        Word inputWord = new Word("answe");

        //when
        Result result = gameMachine.compareWord(inputWord);

        //then
        assertThat(gameMachine.getGameEnd()).isTrue();
    }

    @Test
    @DisplayName("비정답단어 비교시 gameEnd가 false로 셋팅")
    public void compareWord_오답() {
        //given
        AnswerWord answerWord = new AnswerWord("answe");
        gameMachine = new GameMachine(answerWord);
        Word inputWord = new Word("nothi");

        //when
        Result result = gameMachine.compareWord(inputWord);

        //then
        assertThat(gameMachine.getGameEnd()).isFalse();
    }
}