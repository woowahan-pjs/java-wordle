package wordle.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import wordle.exception.WordInputNotValidException;
import wordle.fixture.ResultFixture;

public class WordTest {

    @Test
    void Word를_생성한다() {
        assertDoesNotThrow(() -> new Word("apple"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"test", "testss"})
    void Word를_생성할_때_다섯글자가_아니면_실패한다(String input) {
        assertThatThrownBy(() -> new Word(input))
                .isInstanceOf(WordInputNotValidException.class);
    }

    @Test
    void 같은_Word를_비교하면_초록_결과들을_반환한다(){
        Word baseWord = new Word("abcde");
        Word targetWord = new Word("abcde");

        Results results = baseWord.compare(targetWord);

        assertThat(results).containsExactly(
                ResultFixture.createGreenResult(0),
                ResultFixture.createGreenResult(1),
                ResultFixture.createGreenResult(2),
                ResultFixture.createGreenResult(3),
                ResultFixture.createGreenResult(4));
    }

    @Test
    void 글자는_같지만_위치가_전부_다른_Word를_비교하면_노란_결과들을_반환한다(){
        Word baseWord = new Word("abcde");
        Word targetWord = new Word("edbac");

        Results results = baseWord.compare(targetWord);

        assertThat(results).containsExactly(
                ResultFixture.createYellowResult(0),
                ResultFixture.createYellowResult(1),
                ResultFixture.createYellowResult(2),
                ResultFixture.createYellowResult(3),
                ResultFixture.createYellowResult(4));
    }

    @Test
    void 글자와_위치가_일부가_같은_Word를_비교하면_초록_노란_결과들을_반환한다(){
        Word baseWord = new Word("abcde");
        Word targetWord = new Word("edcba");

        Results results = baseWord.compare(targetWord);

        assertThat(results).containsExactly(
                ResultFixture.createYellowResult(0),
                ResultFixture.createYellowResult(1),
                ResultFixture.createGreenResult(2),
                ResultFixture.createYellowResult(3),
                ResultFixture.createYellowResult(4));
    }

    @Test
    void 글자와_위치가_전부_다른_Word를_비교하면_회색_결과들을_반환한다(){
        Word baseWord = new Word("abcde");
        Word targetWord = new Word("fghij");

        Results results = baseWord.compare(targetWord);

        assertThat(results).containsExactly(
                ResultFixture.createGrayResult(0),
                ResultFixture.createGrayResult(1),
                ResultFixture.createGrayResult(2),
                ResultFixture.createGrayResult(3),
                ResultFixture.createGrayResult(4));
    }
}
