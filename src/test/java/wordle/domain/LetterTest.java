package wordle.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LetterTest {

    @Test
    void test() {
        Letter source = new Letter(0, 'l');
        Letter target = new Letter(1, 'l');

        Result result = source.compare(target);

        assertThat(result).isEqualTo(Result.HALF_CORRECT);
    }

    @Test
    void test2() {
        Letter source = new Letter(1, 'l');
        Letter target = new Letter(1, 'l');

        Result result = source.compare(target);

        assertThat(result).isEqualTo(Result.CORRECT);
    }

    @Test
    void test4() {
        Letter source = new Letter(1, 'l');
        Letter target = new Letter(1, 'p');

        Result result = source.compare(target);

        assertThat(result).isEqualTo(Result.WRONG);
    }

    @Test
    void test5() {
        Letter source = new Letter(2, 'l');
        Letter target = new Letter(1, 'p');

        Result result = source.compare(target);

        assertThat(result).isEqualTo(Result.WRONG);
    }

}
