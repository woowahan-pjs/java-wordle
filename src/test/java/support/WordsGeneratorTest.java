package support;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WordsGeneratorTest {

    @DisplayName("파일에서 Words 를 읽어온다.")
    @Test
    void test01() {
        List<String> words = WordsGenerator.read("src/test/resources/words.txt");

        assertThat(words.size()).isEqualTo(5);
    }
}