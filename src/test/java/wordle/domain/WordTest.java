package wordle.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import wordle.exception.InvalidWordException;
import wordle.fixture.ResultFixture;

public class WordTest {

    @Test
    void Word를_생성한다() {
        assertDoesNotThrow(() -> new Word("apple"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"test", "testss"})
    void Word를_생성할_때_다섯글자가_아니면_실패한다(final String input) {
        assertThatThrownBy(() -> new Word(input))
                .isInstanceOf(InvalidWordException.class);
    }

    @Test
    void 같은_Word를_비교하면_초록_결과들을_반환한다(){
        final Word baseWord = new Word("abcde");
        final Word targetWord = new Word("abcde");

        final Results results = baseWord.compare(targetWord);

        assertThat(results).containsExactly(
                ResultFixture.createGreenResult(new Letter('a', 0)),
                ResultFixture.createGreenResult(new Letter('b', 1)),
                ResultFixture.createGreenResult(new Letter('c', 2)),
                ResultFixture.createGreenResult(new Letter('d', 3)),
                ResultFixture.createGreenResult(new Letter('e', 4))
        );
    }

    @Test
    void 글자는_같지만_위치가_전부_다른_Word를_비교하면_노란_결과들을_반환한다(){
        final Word baseWord = new Word("abcde");
        final Word targetWord = new Word("edbac");

        final Results results = baseWord.compare(targetWord);

        assertThat(results).containsExactly(
                ResultFixture.createYellowResult(new Letter('e', 0)),
                ResultFixture.createYellowResult(new Letter('d', 1)),
                ResultFixture.createYellowResult(new Letter('b', 2)),
                ResultFixture.createYellowResult(new Letter('a', 3)),
                ResultFixture.createYellowResult(new Letter('c', 4))
        );
    }

    @Test
    void 글자와_위치가_일부가_같은_Word를_비교하면_초록_노란_결과들을_반환한다(){
        final Word baseWord = new Word("abcde");
        final Word targetWord = new Word("edcba");

        final Results results = baseWord.compare(targetWord);

        assertThat(results).containsExactly(
                ResultFixture.createYellowResult(new Letter('e', 0)),
                ResultFixture.createYellowResult(new Letter('d', 1)),
                ResultFixture.createGreenResult(new Letter('c', 2)),
                ResultFixture.createYellowResult(new Letter('b', 3)),
                ResultFixture.createYellowResult(new Letter('a', 4))
        );
    }

    @Test
    void 글자와_위치가_전부_다른_Word를_비교하면_회색_결과들을_반환한다(){
        final Word baseWord = new Word("abcde");
        final Word targetWord = new Word("fghij");

        final Results results = baseWord.compare(targetWord);

        assertThat(results).containsExactly(
                ResultFixture.createGrayResult(new Letter('f',0)),
                ResultFixture.createGrayResult(new Letter('g',1)),
                ResultFixture.createGrayResult(new Letter('h',2)),
                ResultFixture.createGrayResult(new Letter('i',3)),
                ResultFixture.createGrayResult(new Letter('j',4))
        );
    }

    @Test
    void 글자와_위치가_전부_같은게_두개_위치만_다른게_한개_전부_다른게_두개인_Word를_비교하면_결과들을_반환한다(){
        final Word answerWord = new Word("abcde"); // 정답
        final Word inputWord = new Word("abejk"); // input

        final Results results = answerWord.compare(inputWord);

        assertThat(results).containsExactly(
                ResultFixture.createGreenResult(new Letter('a', 0)),
                ResultFixture.createGreenResult(new Letter('b', 1)),
                ResultFixture.createYellowResult(new Letter('e', 2)),
                ResultFixture.createGrayResult(new Letter('j', 3)),
                ResultFixture.createGrayResult(new Letter('k', 4))
        );
    }

    @Test
    void 같은_문자가_2개_입력되었을_때_해당_문자가_정답에_하나만_존재하지만_위치가_틀린_경우_첫번째_문자만_노란색으로_반환된다(){
        final Word answerWord = new Word("lurid"); // 정답
        final Word inputWord = new Word("hello"); // input

        final Results results = answerWord.compare(inputWord);

        assertThat(results).containsExactly(
                ResultFixture.createGrayResult(new Letter('h',0)),
                ResultFixture.createGrayResult(new Letter('e',1)),
                ResultFixture.createYellowResult(new Letter('l',2)),
                ResultFixture.createGrayResult(new Letter('l',3)),
                ResultFixture.createGrayResult(new Letter('o',4))
        );
    }
}
