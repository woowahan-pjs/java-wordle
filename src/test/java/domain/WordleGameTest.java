package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WordleGameTest {

    private WordleGame wordleGame = new WordleGame();

    @Test
    void answer_input_같은문자열이면_allGreen_Tile_생성() {
        Wordles wordles = new Wordles("diner", "diner");

        Tile result = wordleGame.start(wordles);

        assertThat(result.printTile()).isEqualTo("\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9");
    }

    @Test
    void answer_input_일부문만같을때_Tile_생성() {
        Wordles wordles = new Wordles("spill", "label");

        Tile result = wordleGame.start(wordles);

        assertThat(result.printTile()).isEqualTo("\uD83D\uDFE8⬜⬜⬜\uD83D\uDFE9");
    }

    @Test
    void answer_input_같은게없으면_white5_생성() {
        Wordles wordles = new Wordles("spill", "abcde");

        Tile result = wordleGame.start(wordles);

        assertThat(result.printTile()).isEqualTo("⬜⬜⬜⬜⬜");
    }

}
