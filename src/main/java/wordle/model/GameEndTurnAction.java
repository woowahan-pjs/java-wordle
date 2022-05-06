package wordle.model;

public class GameEndTurnAction extends GameAction {

	private Grid grid;
	private Word answer;

	public GameEndTurnAction(Grid grid, Word answer) {
		super(GameStatus.END_TURN);
		this.grid = grid;
		this.answer = answer;
	}

	public Grid getGrid() {
		return grid;
	}

	public Word getAnswer() {
		return answer;
	}
}
