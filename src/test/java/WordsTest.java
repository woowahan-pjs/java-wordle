import domain.Word;
import domain.Words;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class WordsTest {

    @Test
    void containsWord(){
        //given
        Words words = new Words("aaaaa", "bbbbb", "ccccc");

        //when
        Assertions.assertTrue(words.contains(new Word("aaaaa")));
        Assertions.assertFalse(words.contains(new Word("ddddd")));
    }

    @Test
    void getArrayLocation(){
        //given
        Words words = new Words("aaaaa", "bbbbb");

        //when
        Word answers = words.answer(LocalDate.of(2021, 6, 20));

        //then
        Assertions.assertEquals(answers, new Word("bbbbb"));
    }

    @Test
    void validation() {
        Words words = new Words("aaaaa");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            words.matchingAnswer(new Word("bbbbb"));
        });
    }
}
