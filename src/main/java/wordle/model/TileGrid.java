package wordle.model;

import java.util.ArrayList;
import java.util.List;

public class TileGrid {

	private static final int MAX_NUMBER_OF_LINES = 6;
	List<TileLine> tileLines = new ArrayList<>();

	public void addTileLine(TileLine tileLine) {
		if (tileLines.size() < MAX_NUMBER_OF_LINES) {
			this.tileLines.add(tileLine);
		}
	}

	public int getNumberOfLines() {
		return tileLines.size();
	}

	public List<TileLine> getTileLines() {
		return tileLines;
	}
}
