package controller;

import java.time.LocalDate;

import domain.Answer;
import domain.Word;
import domain.WordProvider;
import view.InputView;

public class Game {
	private InputView view;
	private Answer answer;
	private WordProvider wordProvider;

	public Game(InputView view, WordProvider wordProvider) {
		this.view = view;
		this.wordProvider = wordProvider;
	}

	public void start(LocalDate currentDate) {
		view.printStartMessage();
		for (int i = 0; i < 6; i++) {
			view.printInputMessage();
			String inputString = view.getUserInput();
			Word userInputWord = Word.from(inputString);

			String answerString = wordProvider.getAnswer(currentDate);
			Word answerWord = Word.from(answerString);

			// List<MatchStatus> result = answerWord.compare(userInputWord);
			// System.out.println("result = " + result);
		}
	}
}
