package wordle.model;

public class Game {

	private Word answer;
	private final GameResult gameResult = new GameResult();

	public Game(Words wordList) {
		init(wordList);
	}

	public void compareWith(String userInput) {
		Word userInputWord = new Word(userInput);
		gameResult.addTiles(answer.calculateMatched(userInputWord));
		answerCheck(userInputWord);
	}

	public void answerCheck(Word userInputWord) {
		if (answer.equals(userInputWord)) {
			gameResult.changeResult(GameStatus.WIN);
			return;
		}

		if (gameResult.isMaxCount()) {
			gameResult.changeResult(GameStatus.LOSE);
			return;
		}
		answer.clearAllMatched();
	}

	public GameResult getResult() {
		return gameResult;
	}

	public Word getAnswer() {
		return answer;
	}

	public GameStatus getGameStatus() {
		return gameResult.getGameStatus();
	}

	private void init(Words wordList) {
		answer = new Word(wordList.getTodayAnswerWord());
	}

}
