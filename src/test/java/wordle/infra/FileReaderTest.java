package wordle.infra;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import wordle.exception.FileReadFailException;

public class FileReaderTest {

    private FileReader fileReader;

    @BeforeEach
    public void setUp() {
        fileReader = new FileReader();
    }

    @Test
    void FileReader로_텍스트파일을_읽어온다() {
        List<String> textList = fileReader.readByLine("words.txt");

        assertThat(textList).containsExactly("hello","label","spell","spill");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"noExist.txt"})
    void FileReader로_없는_파일을_읽어오면_예외를_던진다(final String input) {
        assertThatThrownBy(() -> fileReader.readByLine(input))
                .isInstanceOf(FileReadFailException.class);
    }
}
