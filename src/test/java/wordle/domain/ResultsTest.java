package wordle.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

class ResultsTest {

    @Test
    void Results_생성테스트(){
        Result[] results = createGreenResults(5);

        assertThat(new Results(results)).containsExactly(
                createGreenResult(0),
                createGreenResult(1),
                createGreenResult(2),
                createGreenResult(3),
                createGreenResult(4));
    }

    private static Result[] createGreenResults(int count) {
        return IntStream.range(0, count)
                .mapToObj(ResultsTest::createGreenResult)
                .toArray(Result[]::new);
    }


    private static Result createGreenResult(int position) {
        return new Result(Tile.GREEN, position);
    }

}