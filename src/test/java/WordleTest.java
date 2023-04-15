import domain.Color;
import domain.Colors;
import domain.Word;
import org.junit.jupiter.api.Assertions;
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
        Assertions.assertEquals(
            new Colors(Color.GREY, Color.GREY, Color.YELLOW, Color.GREEN, Color.GREY),
            colors
        );
    }

    @Test
    void readFile() {
        //when
        String[] words = IOUtils.readFromResource("words.txt");

        //then
        Assertions.assertEquals(words[0], "cigar");
    }

    @Test
    void sizeCheck() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Word("aaaa"));
    }
}