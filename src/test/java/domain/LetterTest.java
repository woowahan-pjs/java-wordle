package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LetterTest {
    @Test
    void construct() {
        Letter letter = new Letter('a');
        assertThat(letter).isEqualTo(new Letter('a'));
    }

}
