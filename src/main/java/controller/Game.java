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
	private static final String FILE_PATH = "src/main/resources/words.txt";
	private final InputView inputView;
	private final OutputView outputView;
	private final AnswerGenerator answerGenerator;
	private final Results results;
	private int roundNumber;

	public Game() {
		this.inputView = new InputView();
		this.outputView = new OutputView();
		this.answerGenerator = new AnswerGenerator(FILE_PATH);
		this.results = new Results();
		this.roundNumber = 0;
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
				outputView.print(results);
				break;
			}
			outputView.print(results);
		}
	}
}
