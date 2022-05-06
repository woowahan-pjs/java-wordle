package wordle.model;

public class GameEndTurnAction extends GameAction {

	private Turn turn;
	private Word answer;

	public GameEndTurnAction(Turn turn, Word answer) {
		super(GameStatus.END_TURN);
		this.turn = turn;
		this.answer = answer;
	}

	public Turn getTurn() {
		return turn;
	}

	public Word getAnswer() {
		return answer;
	}
}
