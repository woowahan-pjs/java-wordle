package wordle;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameMachineTest {

    @Test
    void 비교_모두_정답() {
        String 출제자_문제 = "asdfg";
        String 응시자_답변 = "asdfg";
        List<Result> results = GameMachine.compare(출제자_문제, 응시자_답변);

        assertThat(results).containsExactly(Result.정답, Result.정답, Result.정답, Result.정답, Result.정답);
    }

    @Test
    void 혼합된_결과() {
        String 출제자_문제 = "asdfg";
        String 응시자_답변 = "agzxc";
        List<Result> results = GameMachine.compare(출제자_문제, 응시자_답변);

        assertThat(results).containsExactly(Result.정답, Result.틀림, Result.틀림, Result.틀림, Result.문자만_같음);
    }

    @Test
    void find_question() {
//        GameMachine gameMachine = new GameMachine();
//
//        String question = gameMachine.findQuestion();
//
//        Assertions.assertThat(question).isEqualTo("cigar");
    }

    @Test
    void checkAnswerMethodTest() {
        GameMachine gameMachine = new GameMachine();
        Words words = new Words("zzzzz");

        assertThat(gameMachine.checkAnswer(words)).isFalse();
    }

}
