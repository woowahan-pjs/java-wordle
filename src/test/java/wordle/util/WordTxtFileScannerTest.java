package wordle.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.File;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("단어 목록을 읽어서 리스트로 반환 하는 `WordTxtFileScanner` 객체 테스트")
class WordTxtFileScannerTest {

    @DisplayName("존재하는 파일을 넘겨 받는 경우 `WordTxtFileScanner` 객체 생성 성공")
    @Test
    void constructWordTxtFileScannerIsSuccessGivenExistFileInstance() {
        // Arrange
        final File file = new File("./src/main/resources/words.txt");

        // Act
        // Assert
        WordTxtFileScanner wordTxtFileScanner = new WordTxtFileScanner(file);
    }

    @DisplayName("존재하지 않는 파일을 넘겨 받는 경우 `WordTxtFileScanner` 객체 생성 실패")
    @Test
    void constructWordTxtFileScannerIsFailGivenNotExistFileInstance() {
        // Arrange
        final File file = new File("words.txt");

        // Act
        // Assert
        assertThatThrownBy(() -> {
            WordTxtFileScanner wordTxtFileScanner = new WordTxtFileScanner(file);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("올바른 파일이 필요합니다.");
    }

    @DisplayName("`WordTxtFileScanner`가 읽은 `words.txt` 파일의 내용인 단어 목록 반환")
    @Test
    void returnStringListFromWordFileReadByWordTxtFileScanner() {
        // Arrange
        final WordTxtFileScanner wordTxtFileScanner = new WordTxtFileScanner(
                new File("./src/main/resources/words.txt"));

        // Act
        final List<String> words = wordTxtFileScanner.toWordList();

        // Assert
        assertThat(words.size()).isEqualTo(2309);

        assertThat(words.get(0)).isEqualTo("cigar");
        assertThat(words.get(words.size() - 1)).isEqualTo("shave");

        assertThat(words).containsAnyElementsOf(List.of("cigar", "crazy", "sissy", "humph"));
    }
}