package wordle.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import wordle.exception.InvalidPositionException;

public class PositionTest {

    @Test
    void Position은_음수가_될_수_없다() {
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(InvalidPositionException.class);
    }

    @Test
    void Position이_같으면_동등한_객체이다() {
        Position position = createPosition(0);

        assertThat(position).isEqualTo(createPosition(0));
    }

    @Test
    void Position이_다르면_동등하지않은_객체이다() {
        Position position = createPosition(0);

        assertThat(position).isNotEqualTo(createPosition(1));
    }

    private static Position createPosition(int position1) {
        return new Position(position1);
    }
}
