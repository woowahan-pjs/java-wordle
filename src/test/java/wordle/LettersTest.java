package wordle;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LettersTest {

    @DisplayName("Letters를 문자열로 변환한다.")
    @Test
    void combine() {
        Letters letters = new Letters(List.of(new Letter(0, 'h'), new Letter(1, 'e'), new Letter(2, 'l'), new Letter(3, 'l'), new Letter(4, 'o')));

        String result = letters.combine();

        assertThat(result).isEqualTo("hello");
    }

    @DisplayName("위치와 값이 같은 Letter 리스트를 찾아서 반환한다.")
    @Test
    void findSamePositionAndValueLetters() {
        Letters letters = new Letters(List.of(new Letter(0, 'h'), new Letter(1, 'e')));
        Letters other = new Letters(List.of(new Letter(0, 'm'), new Letter(1, 'e') ));

        Letters result = letters.findSamePositionAndValueLetters(other);

        assertThat(result.getLetters()).containsExactly(new Letter(1, 'e'));
    }

    @DisplayName("위치는 다르지만 값이 같은 Letter 리스트를 찾아서 반환한다.")
    @Test
    void findSameValueLetters() {
        Letters letters = new Letters(List.of(new Letter(0, 'h'), new Letter(1, 'e'), new Letter(2, 'l')));
        Letters other = new Letters(List.of(new Letter(0, 'm'), new Letter(1, 'e'), new Letter(2, 'h')));

        Letters result = letters.findSameValueLetters(other);

        assertThat(result.getLetters()).containsExactly(new Letter(0, 'h'));
    }

    @DisplayName("비교 대상 Letter의 값 집합에 포함되지 않는 Letter 리스트를 찾아서 반환한다.")
    @Test
    void findNoneMatchingLetters() {
        Letters letters = new Letters(List.of(new Letter(0, 'h'), new Letter(1, 'e'), new Letter(2, 'l')));
        Letters other = new Letters(List.of(new Letter(0, 'm'), new Letter(1, 'e'), new Letter(2, 'h')));

        Letters result = letters.findNoneMatchingLetters(other);

        assertThat(result.getLetters()).containsExactly(new Letter(2, 'l'));
    }
}
