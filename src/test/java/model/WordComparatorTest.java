package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WordComparatorTest {

    @Test
    @DisplayName("모든 글자가 일치하면 결과는 perfect이다")
    void fullyMatch_compare() {
        WordComparator comparator = new WordComparator();

        WordResult result = comparator.compare("apple", "apple");

        assertTrue(result.isPerfect());
    }

    @Test
    @DisplayName("한 글자도 일치하지 않으면 perfect가 아니다")
    void noMatch_compare() {
        WordComparator comparator = new WordComparator();

        WordResult result = comparator.compare("zzzzz", "apple");

        assertThat(result.isPerfect()).isFalse();
    }

    @Test
    @DisplayName("일부 글자가 정확한 위치에 있으면 perfect가 아니다")
    void partialPerfect_compare() {
        WordComparator comparator = new WordComparator();

        WordResult result = comparator.compare("apric", "apple");

        assertThat(result.isPerfect()).isFalse();

        //a와 p는 완전 일치 → 초록
        //나머지는 불일치 → 흰색
        String expectedTiles = "🟩🟩⬜⬜⬜";
        assertThat(String.join("", result.getTiles())).isEqualTo(expectedTiles);
    }

    @Test
    @DisplayName("일부 글자가 다른 위치에 있으면 노란색 표시")
    void partialMatch_compare() {
        WordComparator comparator = new WordComparator();

        WordResult result = comparator.compare("pleap", "apple");

        assertThat(result.isPerfect()).isFalse();

        //완전 일치 없음 → 초록색 없음
        //모든 글자가 부분 일치 -> 모두 노란색 표시되어야 함
        String expectedTiles = "🟨🟨🟨🟨🟨";

        assertThat(String.join("", result.getTiles())).isEqualTo(expectedTiles);
    }
}
