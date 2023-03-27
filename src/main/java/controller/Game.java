package controller;

import java.time.LocalDate;
import java.util.List;

import domain.Answer;
import domain.Letter;
import domain.MatchStatus;
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
			List<Letter> input = List.of(
				new Letter(inputString.charAt(0),0),
				new Letter(inputString.charAt(1),1),
				new Letter(inputString.charAt(2),2),
				new Letter(inputString.charAt(3),3),
				new Letter(inputString.charAt(4),4));
			String answerString = wordProvider.getAnswer(currentDate);
			Answer answer = new Answer(List.of(
				new Letter(answerString.charAt(0),0),
				new Letter(answerString.charAt(1),1),
				new Letter(answerString.charAt(2),2),
				new Letter(answerString.charAt(3),3),
				new Letter(answerString.charAt(4),4)));
			List<MatchStatus> result = answer.compare(input);
			System.out.println("result = " + result);
		}
	}
}
