import domain.Word;
import domain.Words;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class WordsTest {

    @Test
    void getArrayLocation(){
        //given
        Words words = Words.of(Arrays.asList("aaaaa", "bbbbb"));

        //when
        Word answers = words.answer(LocalDate.of(2021, 6, 20));

        //then
        Assertions.assertEquals(answers, new Word("bbbbb"));
    }

    @Test
    void validation() {
        Words words = Words.of(Arrays.asList("aaaaa"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            words.matchingAnswer(new Word("bbbbb"));
        });
    }
}
