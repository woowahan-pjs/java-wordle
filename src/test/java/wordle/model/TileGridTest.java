package wordle.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TileGridTest {

	@Test
	@DisplayName("TileGrid는 최대 6개의 TileLine을 가진다")
	void TileGrid_has_maximum_six_tile_lines() {
		TileStatus[] tileStatuses = createTileStatusesHasAllGray();
		TileLine tileLine = new TileLine(tileStatuses);
		TileGrid tileGrid = new TileGrid();
		int max_number_of_tile_lines = 6;
		for (int index = 0; index < max_number_of_tile_lines; index++) {
			tileGrid.addTileLine(tileLine);

		}

		assertThatIllegalArgumentException()
			.isThrownBy(() -> tileGrid.addTileLine(tileLine));
	}

	private TileStatus[] createTileStatusesHasAllGray() {
		TileStatus[] tileStatuses = new TileStatus[5];
		for (int index = 0; index < tileStatuses.length; index++) {
			tileStatuses[index] = TileStatus.GRAY;
		}
		return tileStatuses;
	}
}
