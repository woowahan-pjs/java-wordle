package wordle;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import wordle.model.Letter;
import wordle.model.LetterCounter;
import wordle.model.Letters;

class LetterCounterTest {
    @DisplayName("카운트를 감소시킬 수 있는 Letter만 필터링한다.")
    @Test
    void filterCanDecreaseCount() {
        // given
        LetterCounter letterCounter = new LetterCounter(
                new Letters(
                        List.of(
                                new Letter(0, 'a'),
                                new Letter(1, 'b'))
                ));
        Letters target = new Letters(
                List.of(
                        new Letter(0, 'b'),
                        new Letter(0, 'c')
                ));

        // when
        Letters actual = letterCounter.filterCanDecreaseCount(target);

        // then
        assertThat(actual).containsExactly(new Letter(0, 'b'));
    }

    @DisplayName("카운트를 감소시킬 수 없는 Letter만 필터링한다.")
    @Test
    void canNotDecreaseCount() {
        // given
        LetterCounter letterCounter = new LetterCounter(
                new Letters(
                        List.of(
                                new Letter(0, 'a'),
                                new Letter(1, 'b'))
                ));
        Letters target = new Letters(
                List.of(
                        new Letter(0, 'b'),
                        new Letter(0, 'c')
                ));

        // when
        Letters actual = letterCounter.filterCanNotDecreaseCount(target);

        // then
        assertThat(actual).containsExactly(new Letter(0, 'c'));
    }

}
