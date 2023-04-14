import domain.Color;
import domain.Word;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ui.IOUtils;

import java.util.Arrays;
import java.util.List;

import static domain.Color.*;

public class WordleTest {
    @Test
    void compare() {
        Word answer = new Word("spill");
        List<Color> colors = answer.compareWith(new Word("hello"));
        Assertions.assertEquals(Arrays.asList(GREY, GREY, YELLOW, GREEN, GREY), colors);
    }

    @Test
    void readFile() {
        //when
        List<String> words = IOUtils.readFromResource("words.txt");

        //then
        Assertions.assertEquals(words.get(0), "cigar");
    }

    @Test
    void sizeCheck() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Word("aaaa");
        });
    }
}