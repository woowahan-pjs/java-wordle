package wordle.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import wordle.fixture.ResultFixture;

class ResultsTest {

    @Test
    void Results_생성테스트(){
        Result[] results = ResultFixture.createGreenResults(5);

        assertThat(new Results(results)).containsExactly(
                ResultFixture.createGreenResult(0),
                ResultFixture.createGreenResult(1),
                ResultFixture.createGreenResult(2),
                ResultFixture.createGreenResult(3),
                ResultFixture.createGreenResult(4));
    }
}