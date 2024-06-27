package infra;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WordStringLoaderTest {
    @Test
    @DisplayName("단어목록파일 읽기")
    void loadWordsFromFile(){
        List<String> words = WordStringLoader.readAll("src/test/resources/words.txt");
        assertThat(words).containsExactly(
                "cigar",
                "rebut",
                "sissy",
                "humph",
                "awake"
        );
    }
}
