package domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class WordlesTest {

    @Test
    void allGreen() {
        Wordles wordles = new Wordles("spill", "spill");

        List<TileColor> result = wordles.isWordleCompleted();

        assertThat(result).contains(
                TileColor.GREEN,
                TileColor.GREEN,
                TileColor.GREEN,
                TileColor.GREEN,
                TileColor.GREEN
        );
    }

    @Test
    void allGreen2() {
        Wordles wordles = new Wordles("spill", "hello");

        List<TileColor> result = wordles.isWordleCompleted();
        List<TileColor> expected = List.of(TileColor.WHITE,TileColor.WHITE,TileColor.YELLOW,TileColor.GREEN,TileColor.WHITE);

        assertThat(result).containsExactlyElementsOf(expected);
    }

}
