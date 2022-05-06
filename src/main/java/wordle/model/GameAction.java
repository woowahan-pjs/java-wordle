package wordle.model;

public abstract class GameAction {

	private GameStatus gameStatus;

	public GameAction(GameStatus gameStatus) {
		this.gameStatus = gameStatus;
	}

	public boolean isStart() {
		return gameStatus == GameStatus.START;
	}

	public boolean isEndTurn() {
		return gameStatus == GameStatus.END_TURN;
	}
}
