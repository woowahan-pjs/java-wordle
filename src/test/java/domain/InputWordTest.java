package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class InputWordTest {
    @DisplayName("입력단어 유효성 검증 성공 테스트")
    void validateSuccessInputWord() {
        List<String> words = List.of("apples", "cherry");
        assertDoesNotThrow(() -> new InputWord("cherry", words));

    }


    @Test
    @DisplayName("입력단어 유효성 검증 실패 테스트")
    void
    validateFailInputWord() {
        List<String> words = List.of("apples", "banana");
        assertThrows(IllegalArgumentException.class,() -> new InputWord("pangyo", words));
    }

    @Test
    @DisplayName("입력단어 글자수 유효성 검증 실패 테스트")
    void validateInputWordLength() {
        List<String> words = List.of("apple", "abcdef");
        assertThrows(IllegalArgumentException.class,() -> new InputWord("abcdef", words));
    }

    @Test
    @DisplayName("입력단어와 정답 비교")
    void matchTest() {
        List<String> words = List.of("apples", "banana", "cherry");

        InputWord inputWord = new InputWord("cherry", words);
        Answer answer = new Answer("zzzrxx");
        MatchResults matchResults = inputWord.match(answer);

        assertThat(matchResults.getResults()).containsExactly(
                new MatchResult('c', Hint.CORRECT),
                new MatchResult('h', Hint.EXIST),
                new MatchResult('e', Hint.NOT_EXIST),
                new MatchResult('r', Hint.NOT_EXIST),
                new MatchResult('r', Hint.NOT_EXIST),
                new MatchResult('y', Hint.NOT_EXIST)
        );
    }

    @Test
    @DisplayName("입력단어와 정답 위치 확인 테스트")
    void matchLocationTest() {
        List<String> words = List.of("xxxrxr");

        InputWord inputWord = new InputWord("xxxrxr", words);
        Answer answer = new Answer("cherry");
        MatchResults matchResults = inputWord.match(answer);

        assertThat(matchResults.getResults()).containsExactly(
                new MatchResult('x', Hint.NOT_EXIST),
                new MatchResult('x', Hint.NOT_EXIST),
                new MatchResult('x', Hint.NOT_EXIST),
                new MatchResult('r', Hint.CORRECT),
                new MatchResult('x', Hint.NOT_EXIST),
                new MatchResult('r', Hint.EXIST)
        );
    }

    @Test
    @DisplayName("입력단어와 정답 위치 확인 테스트")
    void test() {
        List<String> words = List.of("colon");

        InputWord inputWord = new InputWord("colon", words);
        Answer answer = new Answer("colon");
        MatchResults matchResults = inputWord.match(answer);

        assertThat(matchResults.getResults()).containsExactly(
                new MatchResult('c', Hint.CORRECT),
                new MatchResult('o', Hint.CORRECT),
                new MatchResult('l', Hint.CORRECT),
                new MatchResult('o', Hint.CORRECT),
                new MatchResult('n', Hint.CORRECT)
        );
    }
}
