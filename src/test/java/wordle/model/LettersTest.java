package wordle.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LettersTest {

    @DisplayName("Letters를 문자열로 변환한다.")
    @Test
    void combine() {
        // given
        Letters letters = new Letters(
                List.of(
                        new Letter(0, 'h'),
                        new Letter(1, 'e'),
                        new Letter(2, 'l'),
                        new Letter(3, 'l'),
                        new Letter(4, 'o')
                ));

        // when
        String result = letters.combine();

        // then
        assertThat(result).isEqualTo("hello");
    }

    @DisplayName("위치와 값이 같은 Letter 리스트를 찾아서 반환한다.")
    @Test
    void findSamePositionAndValueLetters() {
        // given
        Letters letters = new Letters(
                List.of(
                        new Letter(0, 'h'),
                        new Letter(1, 'e')
                ));
        Letters other = new Letters(
                List.of(
                        new Letter(0, 'm'),
                        new Letter(1, 'e')
                ));

        // when
        Letters result = letters.findSamePositionAndValueLetters(other);

        // then
        assertThat(result).containsExactly(new Letter(1, 'e'));
    }

    @DisplayName("위치는 다르지만 값이 같은 Letter 리스트를 찾아서 반환한다.")
    @Test
    void findSameValueLetters() {
        // given
        Letters letters = new Letters(
                List.of(
                        new Letter(0, 'h'),
                        new Letter(1, 'e'),
                        new Letter(2, 'l')
                ));
        Letters other = new Letters(
                List.of(
                        new Letter(0, 'm'),
                        new Letter(1, 'e'),
                        new Letter(2, 'h')
                ));

        // when
        Letters result = letters.findSameValueLetters(other);

        // then
        assertThat(result).containsExactly(new Letter(0, 'h'));
    }

    @DisplayName("비교 대상 Letter의 값 집합에 포함되지 않는 Letter 리스트를 찾아서 반환한다.")
    @Test
    void findNoneMatchingLetters() {
        // given
        Letters letters = new Letters(
                List.of(
                        new Letter(0, 'h'),
                        new Letter(1, 'e'),
                        new Letter(2, 'l')
                ));
        Letters other = new Letters(
                List.of(
                        new Letter(0, 'm'),
                        new Letter(1, 'e'),
                        new Letter(2, 'h')
                ));

        // when
        Letters result = letters.findNoneMatchingLetters(other);

        // then
        assertThat(result).containsExactly(new Letter(2, 'l'));
    }
}
