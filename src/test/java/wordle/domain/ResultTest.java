package wordle.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

public class ResultTest {
    @Test
    void Result_생성_테스트() {
        assertDoesNotThrow(()->new Result(Tile.GREEN, 0));
    }
}
