package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class AnswerTest {

    private Word word;

    @BeforeEach
    void setUp() {
        word = Word.from("spill");
    }

    @Test
    @DisplayName("생성자로 인스턴스 만들었을 때 멤버변수에 answer 둥록.")
    void testAnswer() {
        assertAll(
                () -> assertThat(word.get(0)).isEqualTo(new Letter('s', 0)),
                () -> assertThat(word.get(1)).isEqualTo(new Letter('p', 1)),
                () -> assertThat(word.get(2)).isEqualTo(new Letter('i', 2)),
                () -> assertThat(word.get(3)).isEqualTo(new Letter('l', 3)),
                () -> assertThat(word.get(4)).isEqualTo(new Letter('l', 4))
        );
    }

    @Test
    @DisplayName("정답과 입력값 비교하여 MatchStatus 리스트로 반환")
    void testWithInputString() {
        //given
        Answer answer = Answer.from("spill");
        Word target = Word.from("hello");

        //when
        Result result = answer.compare(target);

        //then
        assertThat(result).isEqualTo(
                new Result(List.of(
                        MatchStatus.GRAY,
                        MatchStatus.GRAY,
                        MatchStatus.YELLOW,
                        MatchStatus.GREEN,
                        MatchStatus.GRAY
                )));
    }

    @Test
    @DisplayName("글자가 모두 같으면 Green 만을 가진 결과 반환")
    void allGreenTest() {
        //given
        Answer answer = Answer.from("spill");
        Word target = Word.from("spill");

        //when
        Result result = answer.compare(target);

        //then
        assertThat(result).isEqualTo(
                new Result(List.of(
                        MatchStatus.GREEN,
                        MatchStatus.GREEN,
                        MatchStatus.GREEN,
                        MatchStatus.GREEN,
                        MatchStatus.GREEN
                )));
    }
}
