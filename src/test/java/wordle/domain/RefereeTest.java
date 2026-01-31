package wordle.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RefereeTest {

    @Test
    void 추측단어와_정답이_같은_경우_모두_GREEN이다() {
        // given
        final Referee referee = new Referee("apple");

        // given & when
        final Tile[] result = referee.checkWordle("apple");

        // then
        assertThat(result).containsExactly(
                Tile.GREEN,
                Tile.GREEN,
                Tile.GREEN,
                Tile.GREEN,
                Tile.GREEN
        );
    }

    @Test
    void 추측단어와_정답이_모두_다른경우_GRAY이다() {
        // given
        final Referee referee = new Referee("apple");

        // when
        final Tile[] result = referee.checkWordle("zzzzz");

        // then
        assertThat(result).containsExactly(
                Tile.GRAY,
                Tile.GRAY,
                Tile.GRAY,
                Tile.GRAY,
                Tile.GRAY
        );
    }

    @Test
    void 추측단어와_위치만_다른경우_YELLOW이다() {
        // given
        final Referee referee = new Referee("apple");

        // when
        final Tile[] result = referee.checkWordle("palep");

        // then
        assertThat(result).containsExactly(
                Tile.YELLOW,
                Tile.YELLOW,
                Tile.YELLOW,
                Tile.YELLOW,
                Tile.YELLOW
        );
    }

    @Test
    void 정답보다_입력에_같은_문자가_많으면_남으면_GRAY이다() {
        // given
        final Referee referee = new Referee("apple");

        // when
        final Tile[] result = referee.checkWordle("puppy");

        // then
        assertThat(result).containsExactly(
                Tile.YELLOW,
                Tile.GRAY,
                Tile.GREEN,
                Tile.GRAY,
                Tile.GRAY
        );
    }
}
