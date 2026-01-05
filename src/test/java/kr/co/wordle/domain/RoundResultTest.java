package kr.co.wordle.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RoundResultTest {

    @Test
    void 정답인지_확인() {
        RoundResult roundResult = new RoundResult();
        roundResult.update(Tile.GREEN);
        roundResult.update(Tile.GREEN);
        roundResult.update(Tile.GREEN);
        roundResult.update(Tile.GREEN);
        roundResult.update(Tile.GREEN);
        Assertions.assertTrue(roundResult.isAllGreen());
    }
}
