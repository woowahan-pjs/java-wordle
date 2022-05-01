package wordle.model;

import java.util.ArrayList;
import java.util.List;

public class Grid {

	// todo tilesList -> Grid
	// todo GameResult: Grid, ...
	private static final int MAX_TRYING_COUNT = 6;
	private List<Tiles> tilesList = new ArrayList<>();
	private boolean isCorrect = false;

	public Grid() {
	}

	public void addTiles(Tiles tiles) {
		if (tilesList.size() < MAX_TRYING_COUNT) {
			this.tilesList.add(tiles);
		}
	}

	public List<Tiles> getTilesList() {
		return tilesList;
	}

	public int getTryingCount() {
		return tilesList.size();
	}

	public boolean isFinishedInTrying() {
		return isCorrect;
	}

	public boolean isOverTrying() {
		return tilesList.size() == MAX_TRYING_COUNT && !isCorrect;
	}

	public void corrected() {
		isCorrect = true;
	}
}
