package wordle.infra;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

        assertThat(textList).hasSize(5);
    }

    @Test
    void FileReader로_없는_파일을_읽어오면_예외를_던진다() {
        assertThatThrownBy(() -> fileReader.readByLine("noExist.txt"))
                .isInstanceOf(FileReadFailException.class);
    }
}
