package wordle.model;

import java.util.List;

public class Turn {

	private static final int MAX_TRYING_COUNT = 6;
	private boolean isCorrect = false;
	private TileGrid tileGrid;

	public Turn(TileGrid tileGrid) {
		this.tileGrid = tileGrid;

	}

	public int getTryingCount() {
		return tileGrid.getNumberOfLines();
	}

	public boolean isCorrectedInTrying() {
		return isCorrect;
	}

	public boolean isOver() {
		return !isCorrect && (tileGrid.getNumberOfLines() == MAX_TRYING_COUNT);
	}

	public void corrected() {
		isCorrect = true;
	}

	public List<TileLine> getTileLines() {
		return tileGrid.getTileLines();
	}
}
