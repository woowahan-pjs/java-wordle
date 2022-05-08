package wordle.model;

import java.util.ArrayList;
import java.util.List;

public class TileGrid {

	private static final int MAX_NUMBER_OF_LINES = 6;
	private static final String MAXIMUM_SIZE_OF_TILE_LINES_MESSAGE = "TileGrid는 최대 6개의 TileLine을 가질 수 있습니다.";
	List<TileLine> tileLines = new ArrayList<>();

	public void addTileLine(TileLine tileLine) {
		if (tileLines.size() == MAX_NUMBER_OF_LINES) {
			throw new IllegalArgumentException(MAXIMUM_SIZE_OF_TILE_LINES_MESSAGE);
		}
		this.tileLines.add(tileLine);
	}

	public int getNumberOfLines() {
		return tileLines.size();
	}

	public List<TileLine> getTileLines() {
		return tileLines;
	}
}
