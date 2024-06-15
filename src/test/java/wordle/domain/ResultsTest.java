package wordle.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import wordle.fixture.ResultFixture;

class ResultsTest {

    @Test
    void Results_생성테스트(){
        Results results = ResultFixture.createGreenResults(5);

        assertThat(results).containsExactly(
                ResultFixture.createGreenResult(0),
                ResultFixture.createGreenResult(1),
                ResultFixture.createGreenResult(2),
                ResultFixture.createGreenResult(3),
                ResultFixture.createGreenResult(4));
    }

    @Test
    void Results_가_전부_초록색타일인지_알수있다() {
        Results results = ResultFixture.createGreenResults(5);

        assertThat(results.isAllGreen()).isTrue();
    }
}