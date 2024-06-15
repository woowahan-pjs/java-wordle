package wordle.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import wordle.fixture.ResultFixture;

public class ResultTest {
    @Test
    void Result_생성_테스트() {
        assertDoesNotThrow(()->new Result(Tile.GREEN, 0));
    }

    @Test
    void 타일과_위치가_같으면_동등한_객체이다() {
        Result result = ResultFixture.createGreenResult(0);

        assertThat(result).isEqualTo(new Result(Tile.GREEN, 0));
    }

    @Test
    void 타일이_초록색인지_확인할_수_있다() {
        Result result = ResultFixture.createGreenResult(0);

        assertThat(result.isGreen()).isTrue();
    }
}
