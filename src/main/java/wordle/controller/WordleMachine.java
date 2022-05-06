package wordle.controller;

import wordle.model.Game;
import wordle.model.WordPool;
import wordle.model.WordPoolGenerator;
import wordle.model.WordValidator;
import wordle.view.ConsoleInput;
import wordle.view.ConsoleOutput;

public class WordleMachine {

	private static final WordPool WORD_POOL = WordPoolGenerator.generateFromDefaultFile();
	private final ConsoleInput consoleInput = new ConsoleInput();
	private final ConsoleOutput consoleOutput = new ConsoleOutput();

	public void startGame() {
		Game game = new Game(WORD_POOL);
		ConsoleOutput.printGameAction(game.start());

		while (!game.isFinish()) {
			try {
				game.compareWith(readValidUserInput());
				consoleOutput.printGameResultMessage(game.getResult(), game.getAnswer());
			} catch (Exception e) {
				ConsoleOutput.printGameException(e.getMessage());
			}
		}
	}

	private String readValidUserInput() {
		String userInputWord = "";

		do {
			userInputWord = consoleInput.readUserInput();
		} while (!WordValidator.validate(userInputWord, WORD_POOL));

		return userInputWord;
	}
}
