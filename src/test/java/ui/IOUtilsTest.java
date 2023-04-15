package ui;

import domain.Words;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class IOUtilsTest {

    @Test
    void readFile() {
        //when
        Words words = IOUtils.readFromResource("test_words.txt");

        //then
        Assertions.assertThat(words).isEqualTo(new Words("cigar"));
    }
}