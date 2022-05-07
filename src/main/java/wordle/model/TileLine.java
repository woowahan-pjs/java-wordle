package wordle.model;

import java.util.Objects;

public class TileLine {

	private static final int SIZE_OF_STATUSES = 5;
	private static final String WRONG_LENGTH_MESSAGE = "단어 매칭 결과 값은 5개여야 합니다";
	private TileStatus[] statuses;

	public TileLine(TileStatus[] tileStatuses) {
		validate(tileStatuses);
		this.statuses = tileStatuses;
	}

	private void validate(TileStatus[] tileStatuses) {
		hasFiveStatus(tileStatuses);
		isNotNull(tileStatuses);
	}

	private void isNotNull(TileStatus[] tileStatuses) {
		for (TileStatus tileStatus : tileStatuses) {
			Objects.requireNonNull(tileStatus);
		}
	}

	private void hasFiveStatus(TileStatus[] tileStatuses) {
		if (tileStatuses.length != SIZE_OF_STATUSES) {
			throw new IllegalArgumentException(WRONG_LENGTH_MESSAGE);
		}
	}

	public TileStatus[] getAllStatus() {
		return statuses;
	}
}
