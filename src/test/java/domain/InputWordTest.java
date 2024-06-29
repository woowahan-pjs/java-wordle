package domain;

import infra.WordLoader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class InputWordTest {
    private final List<String> words = getWordList();

    @ParameterizedTest
    @DisplayName("입력단어 유효성 검증 성공 테스트")
    @MethodSource("provideContainedInputWords")
    void validateSuccessInputWord(String input) {
        assertTrue(words.contains(input));
    }

    @ParameterizedTest
    @DisplayName("입력단어 유효성 검증 실패 테스트")
    @ValueSource(strings = {"banana", "hello", "test", "world"})
    void validateFailInputWord(String input) {
        Word word = Word.createInput(input, words);
        assertFalse(word.getAvailableWord());
    }

    @ParameterizedTest
    @ValueSource(strings = {"people"})
    @DisplayName("입력단어 글자수 유효성 검증 실패 테스트")
    void validateInputWordLength(String input) {
        assertTrue(Word.isWrongLength(input));
    }

    @ParameterizedTest
    @DisplayName("입력단어 영단어 유효성 검증 실패 테스트")
    @MethodSource("provideWordsWithLength")
    void validateInputWordOnlyEnglish(String input, boolean isRightWord) {
        if (!isRightWord) {
            Word word = Word.createInput(input, words);
            assertFalse(word.getAvailableWord());
        } else {
            assertFalse(Word.notOnlyEnglish(input));
        }
    }

    private static List<String> getWordList() {
        return WordLoader.read("src/test/resources/words.txt");
    }
    private static Stream<String> provideContainedInputWords() {
        return Stream.of("serve", "sssss", "eeeee", "naval");
    }

    public static Stream<Object[]> provideWordsWithLength() {
        return Stream.of(
                new Object[]{"안녕하세요", false},
                new Object[]{"12345", false},
                new Object[]{"serve", true}
        );
    }
}
