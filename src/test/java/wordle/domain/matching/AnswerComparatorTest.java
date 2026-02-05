package wordle.domain.matching;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class AnswerComparatorTest {

    private final AnswerComparator comparator = new AnswerComparator();

    @ParameterizedTest(name = "{0} vs {1}")
    @DisplayName("완전 일치")
    @CsvSource({
            "APPLE, APPLE",
            "TRAIN, TRAIN",
            "WEARY, WEARY",
            "apple, apple",
            "GRAPE, GRAPE"
    })
    void compare_perfectMatch(String input, String answer) {
        MatchResult[] results = comparator.compare(input, answer);

        for (MatchResult result : results) {
            assertEquals(MatchResult.GREEN, result);
        }
    }

    @ParameterizedTest(name = "{0} vs {1}")
    @DisplayName("완전 불일치")
    @CsvSource({
            "BVSKI, APPLE",
            "ZZZZZ, APPLE",
            "QWXYZ, TRAIN",
            "PILLS, WEARY"
    })
    void compare_noMatch(String input, String answer) {
        MatchResult[] results = comparator.compare(input, answer);

        for (MatchResult result : results) {
            assertEquals(MatchResult.GRAY, result);
        }
    }

    @ParameterizedTest(name = "{0} vs {1} = [{2}]")
    @DisplayName("비교 결과 검증")
    @CsvSource({
            "ELPPA, APPLE, YYGYY", // 부분 일치
            "AAABB, APPLE, GXXXX", // 중복 글자 - 정답에 1개, 입력에 2개
            "PPPAA, APPLE, XGGYX", // 중복 글자 - 정답에 2개, 입력에 3개
            "LLAMA, SHALL, YYGXX", // GREEN이 YELLOW보다 우선
            "TRAIN, PRINT, YGXYY", // 혼합 케이스
            "VAGUE, WEARY, XYXXY", // 실제 Wordle 예제
            "SLATE, RAISE, YXYXG",
            "AROSE, RAISE, YYXGG"
    })
    void compare_variousCases(String input, String answer, String expected) {
        MatchResult[] results = comparator.compare(input, answer);
        String actual = convertToString(results);

        assertEquals(expected, actual,
                String.format("입력: %s, 정답: %s", input, answer));
    }

    @ParameterizedTest(name = "{0} (다양한 케이스)")
    @DisplayName("대소문자 구분 없음")
    @CsvSource({
            "apple, APPLE",
            "APPLE, apple",
            "ApPlE, aPpLe",
            "TrAiN, tRaIn"
    })
    void compare_caseInsensitive(String input, String answer) {
        MatchResult[] results = comparator.compare(input, answer);

        for (MatchResult result : results) {
            assertEquals(MatchResult.GREEN, result);
        }
    }

    @Test
    @DisplayName("중복 글자 복잡한 시나리오 - SPEED vs ERASE")
    void compare_complexDuplicateScenario() {
        MatchResult[] results = comparator.compare("SPEED", "ERASE");
        String actual = convertToString(results);

        assertEquals("YXYYX", actual, "SPEED vs ERASE");
    }

    private String convertToString(MatchResult[] results) {
        StringBuilder sb = new StringBuilder();
        for (MatchResult result : results) {
            sb.append(result == MatchResult.GREEN ? "G" : result == MatchResult.YELLOW ? "Y" : "X");
        }
        return sb.toString();
    }
}
