package controller;

import java.time.LocalDate;

import domain.Answer;
import domain.AnswerGenerator;
import domain.Result;
import domain.Results;
import domain.Word;
import view.InputView;
import view.OutputView;

public class Game {
	private final InputView inputView;
	private final OutputView outputView;
	private final AnswerGenerator answerGenerator;
	private final Results results;
	private int roundNumber;

	public Game(String path) {
		this.inputView = new InputView();
		this.outputView = new OutputView();
		this.answerGenerator = new AnswerGenerator(path);
		this.results = new Results();
		this.roundNumber = 1;
	}

	public void start(LocalDate currentDate) {
		inputView.printStartMessage();

		for (int i = 0; i < 6; i++) {
			roundNumber += 1;
			inputView.printInputMessage();
			String inputString = inputView.getUserInput();
			Word userInputWord = Word.from(inputString);

			String answerString = answerGenerator.getAnswer(currentDate);
			Answer answerWord = Answer.from(answerString);

			Result result = answerWord.compare(userInputWord);
			results.add(result);
			if (results.hasCorrect()) {
				outputView.printRount(roundNumber);
			}
			outputView.print(results);
		}

	}

	private boolean isPlayable() {
		return roundNumber <= 6 || results.hasCorrect();
	}
}
