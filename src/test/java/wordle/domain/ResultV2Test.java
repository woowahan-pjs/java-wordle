package wordle.domain;

import org.junit.jupiter.api.Test;
import wordle.fixture.ResultFixture;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultV2Test {
    @Test
    void 타일과_글자가_같으면_동등한_객체이다() {
        ResultV2 resultV2 = new ResultV2(Tile.GREEN, new Letter('a', 0));

        assertThat(resultV2).isEqualTo(new ResultV2(Tile.GREEN, new Letter('a', 0)));
    }
    @Test
    void 결과와_글자가_같은_위치인지_여부를_알_수_있다() {
        ResultV2 resultV2 = new ResultV2(Tile.GREEN, new Letter('a', 0));

        assertThat(resultV2.isSamePosition(new Letter('b', 0))).isTrue();
    }

    @Test
    void 타일이_초록색인지_확인할_수_있다() {
        ResultV2 resultV2 = ResultFixture.createGreenResult(new Letter('a', 0));

        assertThat(resultV2.isGreen()).isTrue();
    }

    @Test
    void 타일이_노란색인지_확인할_수_있다() {
        ResultV2 resultV2 = ResultFixture.createYellowResult(new Letter('a', 0));

        assertThat(resultV2.isYellow()).isTrue();
    }

    @Test
    void 타일이_회색인지_확인할_수_있다() {
        ResultV2 resultV2 = ResultFixture.createGrayResult(new Letter('a', 0));

        assertThat(resultV2.isGray()).isTrue();
    }
}
