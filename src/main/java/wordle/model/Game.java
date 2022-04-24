package wordle.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Game {

	// grid
	// words
	// gameStatus
	private Word answer;

	// Refactor: wordList를 계속 넘기는 것
	public Game(List<String> wordList) {
		init(wordList);
	}

	private void init(List<String> wordList) {
		//TODO: 오늘 답안 생성
		answer = new Word(getTodayAnswerWord(wordList));
	}

	private String getTodayAnswerWord(List<String> wordList) {
		LocalDate now = LocalDate.now();
		LocalDate past = LocalDate.of(2021, 6, 19);
		// Refactor: offset (+1)
		int period = (int) past.until(now, ChronoUnit.DAYS) + 1;
		return wordList.get(period);
	}

	public boolean isFinish() {
		return false;
	}
}
