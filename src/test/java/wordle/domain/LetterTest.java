package wordle.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LetterTest {

    @Test
    void Letter를_생성한다() {
        assertDoesNotThrow(() -> new Letter('a', 0));
    }
    @Test
    void 알파벳과_위치가_같으면_동등한_객체이다() {
        final Letter letter = new Letter('a', 0);

        assertThat(letter).isEqualTo(new Letter('a', 0));
    }
    @Test
    void 알파벳과이_다르면_동등하지_않은_객체이다() {
        final Letter letter = new Letter('a', 0);

        assertThat(letter).isNotEqualTo(new Letter('b', 0));
    }

    @Test
    void 위치가_다르면_동등하지_않은_객체이다() {
        final Letter letter = new Letter('a', 0);

        assertThat(letter).isNotEqualTo(new Letter('a', 1));
    }

    @Test
    void 알파벳이_같은지_확인할_수_있다() {
        final Letter letter = new Letter('a', 0);

        assertThat(letter.isSameAlphabet(new Letter('a', 1))).isTrue();
    }

    @Test
    void 위치가_같은지_확인할_수_있다() {
        final Letter letter = new Letter('a', 0);

        assertThat(letter.isSamePosition(new Letter('b', 0))).isTrue();
    }

    @Test
    void 정렬을_하면_위치값_기준으로_정렬_된다() {
        final List<Letter> letters = List.of(
                new Letter('a', 0),
                new Letter('a', 4),
                new Letter('a', 3),
                new Letter('a', 1),
                new Letter('a', 2)
        );

        // When
        final List<Letter> sortedList = letters.stream().sorted().toList();

        assertThat(sortedList).isSorted();
    }
}
