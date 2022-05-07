package wordle.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TileLineTest {

	@ParameterizedTest
	@ValueSource(ints = {4, 6})
	@DisplayName("타일 상태 목록의 크기는 5여야 한다")
	void TileLine_has_only_five_tile_status(int lengthOfTileStatuses) {
		TileStatus[] tileStatuses = new TileStatus[lengthOfTileStatuses];
		assertThatIllegalArgumentException().isThrownBy(() -> new TileLine(tileStatuses));
	}

	@Test
	@DisplayName("타일 상태 목록의 요소는 null 이 아니여야 한다")
	void TileStatuses_has_non_null_value() {
		int validSizeOfTileStatuses = 5;
		TileStatus[] tileStatuses = new TileStatus[validSizeOfTileStatuses];
		assertThatNullPointerException().isThrownBy(() -> new TileLine(tileStatuses));
	}
}
