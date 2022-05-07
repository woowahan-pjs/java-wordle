package wordle.model;

public class Game {

	private static final int MAX_TRYING_COUNT = 6;
	private boolean isFinish = false;
	private int tryingCount;
	private Word answer;
	private TileGrid tileGrid = new TileGrid();
	private Turn turn;

	public Game(WordPool wordList) {
		init(wordList);
	}

	public GameAction start() {
		return new GameStartAction();
	}

	private void init(WordPool wordList) {
		answer = new Word(wordList.getTodayAnswerWord());
		turn = new Turn(tileGrid);
	}

	public boolean isFinish() {
		return isFinish;
	}

	public void compareWith(String userInput) {
		Word userInputWord = new Word(userInput);
		tileGrid.addTileLine(answer.calculateMatched(userInputWord));
		plusTryingCount();
		answerCheck(userInputWord);
	}

	public void answerCheck(Word userInputWord) {
		if (answer.equals(userInputWord)) {
			turn.corrected();
			setFinish();
			return;
		}

		if (tryingCount == MAX_TRYING_COUNT) {
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
	}

	public GameAction endTurn() {
		return new GameEndTurnAction(turn, answer);
	}
}
