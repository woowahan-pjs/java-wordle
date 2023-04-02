package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordleTest {

    @Test
    void 동등성_비교_테스트() {
        Wordle wordle1 = new Wordle('a');
        Wordle wordle2 = new Wordle('a');

        boolean actual = wordle1.equals(wordle2);

        assertTrue(actual);
    }

}