package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ColorTest {

    @Test
    void colorGreenTest() {
        //when
        Color green = Color.mapped(new Word("carry"), 'a', 'a');

        //then
        Assertions.assertThat(green).isEqualTo(Color.GREEN);
    }

    @Test
    void colorYellowTest() {
        //when
        Color yellow = Color.mapped(new Word("carry"), 'r', 'a');

        //then
        Assertions.assertThat(yellow).isEqualTo(Color.YELLOW);
    }

    @Test
    void colorGreyTest() {
        //when
        Color grey = Color.mapped(new Word("carry"), 'r', 'd');

        //then
        Assertions.assertThat(grey).isEqualTo(Color.GREY);
    }
}
