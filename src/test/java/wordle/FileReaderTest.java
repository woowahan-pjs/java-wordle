package wordle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FileReaderTest {

    @DisplayName("파일 명을 받아 파일내용을 읽는다")
    @Test
    void readAll() {
        FileReader fileReader = new FileReader();

        List<String> lines = fileReader.readAll("sample.txt");

        assertThat(lines).containsExactly("asdfg", "zxcvb");
    }
}