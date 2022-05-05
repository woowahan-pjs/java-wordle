package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MatchResultTest {

    @Test
    void 매칭이_정확하게_일치하면_참() {
        List<MatchStatus> exactMatchedList = List.of(MatchStatus.GREEN, MatchStatus.GREEN, MatchStatus.GREEN, MatchStatus.GREEN, MatchStatus.GREEN);
        MatchResult matchResult = new MatchResult(exactMatchedList);

        assertThat(matchResult.isCorrect()).isTrue();
    }

    @ParameterizedTest
    @MethodSource("nonMatchStatusList")
    void 매칭이_정확하게_일치하지_않으면_거짓(List<MatchStatus> nonMatchStatusList) {

        MatchResult matchResult = new MatchResult(nonMatchStatusList);
        assertThat(matchResult.isCorrect()).isFalse();
    }

    private static Stream<Arguments> nonMatchStatusList() {
        return Stream.of(
                Arguments.of(List.of(MatchStatus.GREEN, MatchStatus.GREEN, MatchStatus.GREEN, MatchStatus.GREEN, MatchStatus.GREY)),
                Arguments.of(List.of(MatchStatus.GREEN, MatchStatus.GREEN, MatchStatus.YELLOW, MatchStatus.YELLOW, MatchStatus.GREY)),
                Arguments.of(List.of(MatchStatus.GREEN, MatchStatus.GREEN, MatchStatus.GREEN, MatchStatus.YELLOW, MatchStatus.YELLOW))
        );
    }


}
