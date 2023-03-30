package controller;

import java.time.LocalDate;

import domain.Answer;
import domain.Word;
import domain.AnswerGenerator;
import view.InputView;

public class Game {
	private final InputView view;
	private Answer answer;
	private AnswerGenerator answerGenerator;

	public Game(InputView view, AnswerGenerator answerGenerator) {
		this.view = view;
		this.answerGenerator = answerGenerator;
	}

	public void start(LocalDate currentDate) {
		view.printStartMessage();
		for (int i = 0; i < 6; i++) {
			view.printInputMessage();
			String inputString = view.getUserInput();
			Word userInputWord = Word.from(inputString);

			String answerString = answerGenerator.getAnswer(currentDate);
			Word answerWord = Word.from(answerString);

			// List<MatchStatus> result = answerWord.compare(userInputWord);
			// System.out.println("result = " + result);
		}
	}
}
