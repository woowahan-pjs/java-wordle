package wordle.domain;

import org.junit.jupiter.api.Test;
import wordle.fixture.ResultFixture;

import static org.assertj.core.api.Assertions.assertThat;

class ResultsTest {

    @Test
    void Results_생성테스트() {
        final Results results = ResultFixture.createGreenResults(5);

        assertThat(results).containsExactly(
                ResultFixture.createGreenResult(new Letter('a', 0)),
                ResultFixture.createGreenResult(new Letter('a', 1)),
                ResultFixture.createGreenResult(new Letter('a', 2)),
                ResultFixture.createGreenResult(new Letter('a', 3)),
                ResultFixture.createGreenResult(new Letter('a', 4)));
    }

    @Test
    void Results_가_전부_초록색타일인지_알수있다() {
        final Results results = ResultFixture.createGreenResults(5);

        assertThat(results.isAllGreen()).isTrue();
    }
}
