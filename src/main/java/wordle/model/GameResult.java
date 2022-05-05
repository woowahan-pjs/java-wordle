package wordle.model;

import java.util.List;

public class GameResult {
	private final Grid grid = new Grid();
	private static final int MAX_TRYING_COUNT = 6;
	private GameStatus gameStatus;

	public GameResult() {
		gameStatus = GameStatus.PROGRESS;
	}

	public void addTiles(Tiles tiles) {
		grid.addTiles(tiles);
	}

	public List<Tiles> getTilesList() {
		return grid.getTilesList();
	}

	public boolean isFinishedInTrying() {
		return gameStatus == GameStatus.WIN;
	}

	public boolean isOverTrying() {
		return gameStatus == GameStatus.LOSE;
	}

	public int getTryingCount() {
		return grid.getTilesList().size();
	}

	public boolean isMaxCount() {
		return getTryingCount() == MAX_TRYING_COUNT;
	}

	public GameStatus getGameStatus() {
		return this.gameStatus;
	}

	public void changeResult(GameStatus gameStatus) {
		this.gameStatus = gameStatus;
	}
}
