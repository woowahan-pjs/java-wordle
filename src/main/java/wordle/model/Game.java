package wordle.model;

public class Game {

	private static final int MAX_TRYING_COUNT = 6;
	private Word answer;
	private int tryingCount;
	private Grid grid = new Grid();
	private boolean isFinish = false;

	public Game(WordPool wordList) {
		init(wordList);
	}

	private void init(WordPool wordList) {
		answer = new Word(wordList.getTodayAnswerWord());
	}

	public boolean isFinish() {
		return isFinish;
	}

	public void compareWith(String userInput) {
		// 오늘 정답 단어와 입력받은 단어와 비교 후 결과 출력
		Word userInputWord = new Word(userInput);
		Tiles tiles = answer.calculateMatched(userInputWord);
		grid.addTiles(tiles);
		plusTryingCount();
		if (allMatched(tiles)) {
			grid.addAnswerWord(answer);
			setFinish();
			grid.giveAnswer();
			return;
		}
		if (tryingCount == MAX_TRYING_COUNT) {
			setFinish();
			grid.addAnswerWord(answer);
			return;
		}
		answer.clearAllMatched();
	}

	private boolean allMatched(Tiles tiles) {
		return tiles.isAllMatched();
	}

	private void setFinish() {
		this.isFinish = true;
	}

	private void plusTryingCount() {
		tryingCount++;
	}

	public Grid getResult() {
		return grid;
	}
}
