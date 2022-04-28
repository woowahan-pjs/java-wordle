package wordle.model;

public class Game {

	// grid
	// words
	// gameStatus
	private Word answer;

	// Refactor: wordList를 계속 넘기는 것
	public Game(WordPool wordList) {
		init(wordList);
	}

	private void init(WordPool wordList) {
		//TODO: 오늘 답안 생성
		answer = new Word(wordList.getTodayAnswerWord());
	}

	public boolean isFinish() {
		return false;
	}
}
