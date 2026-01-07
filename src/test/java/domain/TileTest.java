package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class TileTest {

    @DisplayName("답안과 정답의 글자가 동일하고 워드에 들어있는 동일한 글자의 합계가 1이상이면 초록색 타일을 반환한다.")
    @Test
    void test01() {
        Long count = 1L;
        Letter answerLetter = new Letter('I');
        Letter letter = new Letter('I');

        assertThat(Tile.getTile(count, answerLetter, letter)).isEqualTo(Tile.GREEN);
    }

    @DisplayName("답안과 정답이 동일하지 않고 워드에 들어있는 동일한 글자의 합계가 1이상이면 노란색 타일을 반환한다.")
    @Test
    void test02() {
        Long count = 1L;
        Letter answerLetter = new Letter('I');
        Letter letter = new Letter('E');

        assertThat(Tile.getTile(count, answerLetter, letter)).isEqualTo(Tile.YELLOW);
    }

    @DisplayName("워드에 들어있는 동일한 글자의 합계가 0 또는 빈 값이면 회색 타일을 반환한다.")
    @Test
    void test03() {
        Long count = 0L;
        Letter answerLetter = new Letter('I');
        Letter letter = new Letter('I');

        assertThat(Tile.getTile(count, answerLetter, letter)).isEqualTo(Tile.GRAY);
    }
}
