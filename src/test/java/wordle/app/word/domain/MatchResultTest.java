package wordle.app.word.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MatchResultTest {

    @Test
    void isCorrect가_True() {
        final List<MatchStatus> matchStatusList = List.of(MatchStatus.GREEN, MatchStatus.GREEN, MatchStatus.GREEN, MatchStatus.GREEN, MatchStatus.GREEN);
        final MatchResult matchResult = new MatchResult(matchStatusList);

        assertThat(matchResult.isCorrect()).isTrue();
    }

    @ParameterizedTest
    @MethodSource("matchStatusListParam")
    void isCorrect가_False(final List<MatchStatus> matchStatusList) {
        final MatchResult matchResult = new MatchResult(matchStatusList);

        assertThat(matchResult.isCorrect()).isFalse();
    }

    private static Stream<Arguments> matchStatusListParam() {
        return Stream.of(
                Arguments.of(List.of(MatchStatus.GREEN, MatchStatus.GREEN, MatchStatus.GREEN, MatchStatus.GREY, MatchStatus.GREEN)),
                Arguments.of(List.of(MatchStatus.YELLOW, MatchStatus.YELLOW, MatchStatus.GREEN, MatchStatus.GREY, MatchStatus.GREEN)),
                Arguments.of(List.of(MatchStatus.YELLOW, MatchStatus.GREEN, MatchStatus.YELLOW, MatchStatus.GREY, MatchStatus.GREEN))
        );
    }

}
