package domain.service;

import application.port.OutputPort;
import domain.model.Result;
import domain.model.ResultValues;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {

    // Mockup
    private OutputPort outputPort = new OutputPort() {
        @Override
        public String getWelcomeMessage() { return ""; }
        @Override
        public String getInputInfoMessage() { return ""; }
        @Override
        public String getBoards(StringBuilder[] boards) { return ""; }
        @Override
        public String getHasNotWordRepository() { return ""; }
        @Override
        public String getInvalidInputMessage() { return ""; }
        @Override
        public String getLengthMismatchMessage() { return ""; }
        @Override
        public String getNotAlphabetMessage() { return ""; }
        @Override
        public String getTryCountExceededMessage() { return ""; }
    };

    @Test
    public void 종료_조건_테스트_6턴_이내() {
        // given
        Result result = new Result();
        result.setCurrentBoardsIndex(5);
        Game game = new Game(result, outputPort);
        // when
        // then
        Assertions.assertTrue(game.checkedTryCount());
    }


    @Test
    public void 종료_조건_테스트_6턴_초과_불가() {
        // given
        Result result = new Result();
        result.setCurrentBoardsIndex(6);
        Game game = new Game(result, outputPort);
        // when
        boolean resultChecked = game.checkedTryCount();
        // then
        Assertions.assertFalse(resultChecked);
    }

    @Test
    public void 종료_조건_정답_성공_시_종료() {
        // given
        Result result = new Result();
        StringBuilder board = new StringBuilder(ResultValues.correct());
        result.setBoard(board);
        Game game = new Game(result, outputPort);
        // when
        game.updateFinished();
        // then
        Assertions.assertTrue(game.isFinished());
    }

    @Test
    public void 종료_조건_정답_실패_시_종료안됨() {
        // given
        Result result = new Result();
        StringBuilder board = new StringBuilder(ResultValues.inCorrect());
        result.setBoard(board);
        Game game = new Game(result, outputPort);
        // when
        game.updateFinished();
        // then
        Assertions.assertFalse(game.isFinished());
    }


}
