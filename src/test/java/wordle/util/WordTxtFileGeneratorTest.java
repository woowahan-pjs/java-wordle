package wordle.util;

import static org.assertj.core.api.Assertions.assertThat;
import static wordle.util.WordTxtFileGenerator.generateFromFileName;

import java.io.File;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("단어 목록이 있는 텍스트 파일을 읽는 함수 테스트")
public class WordTxtFileGeneratorTest {

    @DisplayName("파일이 존재하는 경우 파일을 읽으면 파일 객체 생성")
    @Test
    public void returnFileInstanceWhenFileIsExistInResourceDirectory() {
        // Arrange
        final File wordFile = generateFromFileName("words.txt");

        // Act
        final boolean fileExist = wordFile.exists();

        // Assert
        assertThat(fileExist).isTrue();
    }

    @DisplayName("파일이 존재하지 않는 경우 파일을 읽으면 빈 파일 객체 생성")
    @ParameterizedTest
    @ValueSource(strings = {"notExist.txt", "AA.bb", "test.img", "ABC.pdf"})
    public void returnEmptyFileInstanceWhenFileIsNotExistInResourceDirectory(String wordTxtFileName) {
        // Arrange
        final File wordFile = generateFromFileName(wordTxtFileName);

        // Act
        final boolean fileExist = wordFile.exists();

        // Assert
        assertThat(fileExist).isFalse();
    }
}
