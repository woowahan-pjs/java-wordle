package wordle.model;

public abstract class GameAction {

	private GameStatus gameStatus;

	public GameAction(GameStatus gameStatus) {
		this.gameStatus = gameStatus;
	}

	public boolean isStart() {
		return gameStatus == GameStatus.START;
	}

	;

	public boolean isResult() {
		return gameStatus == GameStatus.RESULT;
	}

	;
}
