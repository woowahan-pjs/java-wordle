package wordle.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GridTest {

	@ParameterizedTest
	@ValueSource(ints = {6, 7, 8})
	void 사용자_입력에_대한_결과가_6개_이상인_경우에도_타일은_6개를_가지고_있다(int count) {
		// given
		TileStatus[] tileStatuses = new TileStatus[]{TileStatus.GREEN, TileStatus.GREEN, TileStatus.GREEN,
			TileStatus.GREEN, TileStatus.GREEN};
		Grid grid = new Grid();

		// when
		for (int i = 1; i <= count; i++) {
			grid.addTiles(new Tiles(tileStatuses));
		}

		// then
		assertThat(grid.getTilesList().size()).isEqualTo(6);
	}
}
