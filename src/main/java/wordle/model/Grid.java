package wordle.model;

import java.util.ArrayList;
import java.util.List;

public class Grid {
	private static final int MAX_TRYING_COUNT = 6;
	private final List<Tiles> tilesList = new ArrayList<>();

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
}
