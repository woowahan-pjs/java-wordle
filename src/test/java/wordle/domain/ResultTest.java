package wordle.domain;

import org.junit.jupiter.api.Test;
import wordle.fixture.ResultFixture;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {
    @Test
    void 타일과_글자가_같으면_동등한_객체이다() {
        final Result result = new Result(Tile.GREEN, new Letter('a', 0));

        assertThat(result).isEqualTo(new Result(Tile.GREEN, new Letter('a', 0)));
    }
    @Test
    void 결과와_글자가_같은_위치인지_여부를_알_수_있다() {
        final Result result = new Result(Tile.GREEN, new Letter('a', 0));

        assertThat(result.isSamePosition(new Letter('b', 0))).isTrue();
    }

    @Test
    void 타일이_초록색인지_확인할_수_있다() {
        final Result result = ResultFixture.createGreenResult(new Letter('a', 0));

        assertThat(result.isGreen()).isTrue();
    }

    @Test
    void 타일이_노란색인지_확인할_수_있다() {
        final Result result = ResultFixture.createYellowResult(new Letter('a', 0));

        assertThat(result.isYellow()).isTrue();
    }

    @Test
    void 타일이_회색인지_확인할_수_있다() {
        final Result result = ResultFixture.createGrayResult(new Letter('a', 0));

        assertThat(result.isGray()).isTrue();
    }
}
