package wordle.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AlphabetTest {

    @Test
    void 소문자_영단어로_Alphabet을_생성할_수_있다() {
        assertDoesNotThrow(() -> Alphabet.of('a'));
    }

    @Test
    void 소문자가_아닌_단어가_들어온다면_Alphabet을_생성할_수_없다() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> Alphabet.of('A')),
                () -> assertThrows(IllegalArgumentException.class, () -> Alphabet.of('1')),
                () -> assertThrows(IllegalArgumentException.class, () -> Alphabet.of('ㄱ'))
        );
    }
}
