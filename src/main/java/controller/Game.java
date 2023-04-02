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

	public Game(String path) {
		this.inputView = new InputView();
		this.outputView = new OutputView();
		this.answerGenerator = new AnswerGenerator(path);
		this.results = new Results();
	}

	public void start(LocalDate currentDate) {
		inputView.printStartMessage();
		for (int i = 0; i < 6; i++) {
			inputView.printInputMessage();
			String inputString = inputView.getUserInput();
			Word userInputWord = Word.from(inputString);

			String answerString = answerGenerator.getAnswer(currentDate);
			Answer answerWord = Answer.from(answerString);

			Result result =  answerWord.compare(userInputWord);
			results.add(result);
			outputView.print(results);

		}

	}
}
