package wordle.model;

public class Tiles {

	private static final int MAX_TILE_STATUS_COUNT = 5;
	private TileStatus[] status;

	public Tiles(TileStatus[] status) {
		this.status = status;
	}

	public TileStatus[] getStatus() {
		return status;
	}

	public boolean isAllMatched() {
		int greenCount = 0;

		for (TileStatus tileStatus : status) {
			if (tileStatus == TileStatus.GREEN) {
				greenCount++;
			}
		}

		if (greenCount == MAX_TILE_STATUS_COUNT) {
			return true;
		}
		return false;
	}
}
