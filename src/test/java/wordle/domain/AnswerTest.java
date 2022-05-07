package wordle.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AnswerTest {

    @Test
    void matches성공_5개모두일치함() {
        final String input = "happy";
        final Answer answer = new Answer(new Words(input));
        final Words words = new Words(input);

        final MatchResult matches = answer.matches(words);
        assertThat(matches.isCorrect()).isTrue();
    }

    @Test
    void matches성공_일부성공함() {
        final Answer answer = new Answer(new Words("shown"));
        final Words words = new Words("happy");

        final MatchResult matches = answer.matches(words);
        assertThat(matches.isCorrect()).isFalse();
        assertThat(matches.getMatchStatusList().contains(MatchStatus.GREEN)).isFalse();
        assertThat(matches.getMatchStatusList().contains(MatchStatus.YELLOW)).isTrue();
        assertThat(matches.getMatchStatusList().contains(MatchStatus.GREY)).isTrue();
    }

    @Test
    void matches성공_모두일치하지않음() {
        final String input = "happy";
        final Answer answer = new Answer(new Words(input));
        final Words words = new Words("hasdf");

        final MatchResult matches = answer.matches(words);
        assertThat(matches.isCorrect()).isFalse();
    }

}