package wordle.model;

public class Game {

	private static final int MAX_TRYING_COUNT = 6;
	private boolean isFinish = false;
	private int tryingCount;
	private Word answer;
	private TileGrid tileGrid = new TileGrid();
	private Turn turn;

	public Game(WordPool wordPool) {
		init(wordPool);
	}

	public GameAction start() {
		return new GameStartAction();
	}

	public GameAction progressTurn(String userInputString) {
		Word userInputWord = new Word(userInputString);
		tileGrid.addTileLine(answer.match(userInputWord));
		answerCheck(userInputWord);
		plusTryingCount();
		return creatEndTurn();
	}

	private void init(WordPool wordList) {
		answer = new Word(wordList.getTodayAnswerWord());
		turn = new Turn(tileGrid);
	}

	public boolean isFinish() {
		return isFinish;
	}

	public void answerCheck(Word userInputWord) {
		if (answer.equals(userInputWord)) {
			turn.corrected();
			setFinish();
			return;
		}
		answer.clearAllMatched();
	}

	private void setFinish() {
		this.isFinish = true;
	}

	private void plusTryingCount() {
		tryingCount++;

		if (tryingCount == MAX_TRYING_COUNT) {
			setFinish();
			return;
		}
	}

	private GameAction creatEndTurn() {
		return new GameEndTurnAction(turn, answer);
	}
}
