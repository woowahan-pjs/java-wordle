import domain.Color;
import domain.Word;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ui.IOUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

public class WordleTest {
    @Test
    void compare() {
        Word answer = new Word("spill");
        List<Color> colors = answer.compareWith(new Word("hello"));
        Assertions.assertEquals(Arrays.asList(Color.GREY, Color.GREY, Color.YELLOW, Color.GREEN, Color.GREY), colors);
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
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Word("aaaa");
        });
    }
}