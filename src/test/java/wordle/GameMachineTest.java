package wordle;

import org.junit.jupiter.api.Test;
import wordle.domain.Result;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameMachineTest {

    @Test
    void 비교_모두_정답() {
        String 출제자_문제 = "asdfg";
        String 응시자_답변 = "asdfg";
        List<Result> results = GameMachine.compare(출제자_문제, 응시자_답변);
        assertThat(results).containsExactly(Result.CORRECT, Result.CORRECT, Result.CORRECT, Result.CORRECT, Result.CORRECT);
    }

    @Test
    void 혼합된_결과() {
        String 출제자_문제 = "asdfg";
        String 응시자_답변 = "agzxc";
        List<Result> results = GameMachine.compare(출제자_문제, 응시자_답변);
        assertThat(results).containsExactly(Result.CORRECT, Result.WRONG, Result.WRONG, Result.WRONG, Result.HALF_CORRECT);
    }

}
