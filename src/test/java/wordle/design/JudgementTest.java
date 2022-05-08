package wordle.design;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import wordle.domain.design.Judgement;
import wordle.domain.model.JudgementImpl;
import wordle.domain.vo.Color;
import wordle.domain.vo.JudgeResult;
import wordle.domain.vo.UserWord;

class JudgementTest {
    private Judgement judgement = new JudgementImpl();

    @Test
    @DisplayName("정답이 맞은 경우 [Green,Green,Green,Green,Green]를 반환한다")
    public void test1() {
        // given
        String ans = "apple";
        UserWord input = UserWord.of("apple");

        // when
        JudgeResult result = judgement.execute(ans, input);

        // then
        Color[] colors = result.getResult();
        assertThat(colors[0]).isEqualTo(Color.GREEN);
        assertThat(colors[1]).isEqualTo(Color.GREEN);
        assertThat(colors[2]).isEqualTo(Color.GREEN);
        assertThat(colors[3]).isEqualTo(Color.GREEN);
        assertThat(colors[4]).isEqualTo(Color.GREEN);
    }

    @Test
    @DisplayName("정답이 1개만 맞은 경우 [Green,Gray,Gray,Gray,Gray]를 반환한다")
    public void test2() {
        // given
        String ans = "apple";
        UserWord input = UserWord.of("affxk");

        // when
        JudgeResult result = judgement.execute(ans, input);

        // then
        Color[] colors = result.getResult();
        assertThat(colors[0]).isEqualTo(Color.GREEN);
        assertThat(colors[1]).isEqualTo(Color.GRAY);
        assertThat(colors[2]).isEqualTo(Color.GRAY);
        assertThat(colors[3]).isEqualTo(Color.GRAY);
        assertThat(colors[4]).isEqualTo(Color.GRAY);
    }

    @Test
    @DisplayName("정답이 모두 존재하지 않는 경우 [Gray,Gray,Gray,Gray,Gray]를 반환한다")
    public void test3() {
        // given
        String ans = "apple";
        UserWord input = UserWord.of("bcckf");

        // when
        JudgeResult result = judgement.execute(ans, input);

        // then
        Color[] colors = result.getResult();
        assertThat(colors[0]).isEqualTo(Color.GRAY);
        assertThat(colors[1]).isEqualTo(Color.GRAY);
        assertThat(colors[2]).isEqualTo(Color.GRAY);
        assertThat(colors[3]).isEqualTo(Color.GRAY);
        assertThat(colors[4]).isEqualTo(Color.GRAY);
    }

    @Test
    @DisplayName("순서가 모두 바뀐 경우 [Yellow,Yellow,Yellow,Yellow,Yellow]를 반환한다")
    public void test4() {
        // given
        String ans = "apple";
        UserWord input = UserWord.of("palep");

        // when
        JudgeResult result = judgement.execute(ans, input);

        // then
        Color[] colors = result.getResult();
        assertThat(colors[0]).isEqualTo(Color.YELLOW);
        assertThat(colors[1]).isEqualTo(Color.YELLOW);
        assertThat(colors[2]).isEqualTo(Color.YELLOW);
        assertThat(colors[3]).isEqualTo(Color.YELLOW);
        assertThat(colors[4]).isEqualTo(Color.YELLOW);
    }
}
