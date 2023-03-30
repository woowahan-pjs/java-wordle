package controller;

import java.time.LocalDate;

import domain.Answer;
import domain.AnswerGenerator;
import domain.Result;
import domain.Word;
import view.InputView;

public class Game {
	private final InputView view;
	private final AnswerGenerator answerGenerator;

	public Game(String path) {
		this.view = new InputView();
		this.answerGenerator = new AnswerGenerator(path);
	}

	public void start(LocalDate currentDate) {
		view.printStartMessage();
		for (int i = 0; i < 6; i++) {
			view.printInputMessage();
			String inputString = view.getUserInput();
			Word userInputWord = Word.from(inputString);

			String answerString = answerGenerator.getAnswer(currentDate);
			Answer answerWord = Answer.from(answerString);

			Result result =  answerWord.compare(userInputWord);
			System.out.println("result = " + result);
		}
	}
}
