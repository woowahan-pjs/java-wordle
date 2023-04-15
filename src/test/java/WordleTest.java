import domain.Color;
import domain.Colors;
import domain.Word;
import domain.Words;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import ui.IOUtils;

public class WordleTest {

    @Test
    void compare() {
        //given
        Word answer = new Word("spill");

        //when
        Colors colors = answer.compareWith(new Word("hello"));

        //then
        Assertions.assertThat(colors).isEqualTo(
            new Colors(Color.GREY, Color.GREY, Color.YELLOW, Color.GREEN, Color.GREY)
        );
    }

    @Test
    void readFile() {
        //when
        Words words = IOUtils.readFromResource("test_words.txt");

        //then
        Assertions.assertThat(words).isEqualTo(new Words("cigar"));
    }

    @Test
    void sizeCheck() {
        Assertions.assertThatThrownBy(() -> new Words("aaaa"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("단어는 다섯글자로만 입력 가능합니다");
    }
}