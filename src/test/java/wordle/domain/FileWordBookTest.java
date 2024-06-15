package wordle.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import wordle.TimeTestSupporter;
import wordle.infra.FileReader;

public class FileWordBookTest {

    private WordBook wordBook;

    @BeforeEach
    void setUp() {
        wordBook = new FileWordBook(new FileReader());
    }

    @ParameterizedTest
    @CsvSource(value = {"hello:true", "exist:false"}, delimiter = ':')
    void WordBook에_단어가_존재하는지_확인_할_수있다(String input, boolean expected) {
        final boolean actual = wordBook.exist(new Word(input));

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2024-06-08:apple",
            "2024-06-09:hello",
            "2024-06-10:abcde",
            "2024-06-11:spike",
            "2024-06-12:happy"
    }, delimiter = ':')
    void WordBook에서_공식을_통해_오늘의_정답_단어를_뽑는다(LocalDate mockDate, String expected) {
        TimeTestSupporter.runWithMock(mockDate, () -> {
            Word actual = wordBook.pick(new BaseAnswerFormula());

            assertThat(actual).isEqualTo(new Word(expected));
        });
    }

    @Test
    void WordBook에서_단어를_찾을_수_있다() {
        Word word = wordBook.find("happy");

        assertThat(word).isNotNull();
    }

    @Test
    void WordBook에_없는_단어를_찾으면_예외를_던진다() {
        assertThatThrownBy(() -> wordBook.find("ghost"));
    }
}
