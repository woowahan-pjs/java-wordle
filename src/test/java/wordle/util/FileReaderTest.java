package wordle.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FileReaderTest {

    private FileReader reader;

    @BeforeEach
    void setUp() {
        reader = new FileReader();
    }

    @Test
    void FileReader로_텍스트_파일을_읽어오는데_성공했다() {
        final List<String> testList = reader.readByLine("words.txt");

        assertThat(testList).isNotEmpty();
        assertThat(testList).contains("awake", "naval", "abate");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"", "  ", "test.txt"})
    void FileReader로_텍스트_파일을_읽어오는데_실패하면_예외를_던진다(final String input) {
        assertThatThrownBy(() -> reader.readByLine(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}