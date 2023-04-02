package domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class WordlesTest {

    @Test
    void allGreen() {
        Wordles wordles = new Wordles("spill", "spill");

        List<TileColor> result = wordles.makeTileColorList();

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

        List<TileColor> result = wordles.makeTileColorList();
        List<TileColor> expected = List.of(TileColor.WHITE,TileColor.WHITE,TileColor.YELLOW,TileColor.GREEN,TileColor.WHITE);

        assertThat(result).containsExactlyElementsOf(expected);
    }

    @Test
    void test() {
        Wordles wordles = new Wordles("hello", "oabco");

        List<TileColor> result = wordles.makeTileColorList();
        System.out.println(result);
    }

}
