package wordle.controller;

import wordle.model.Game;
import wordle.model.WordPool;
import wordle.model.WordPoolGenerator;
import wordle.model.WordValidator;
import wordle.view.ConsoleInput;
import wordle.view.ConsoleOutput;

public class WordleMachine {

	private static final WordPool WORD_POOL = WordPoolGenerator.generateFromDefaultFile();

	public void startGame() {
		Game game = new Game(WORD_POOL);
		ConsoleOutput.printGameAction(game.start());

		while (!game.isFinish()) {
			try {
				ConsoleOutput.printGameAction(game.progressTurn(readValidUserInput()));
			} catch (Exception e) {
				ConsoleOutput.printGameMessage(e.getMessage());
			}
		}
	}

	private String readValidUserInput() {
		String userInputWord = "";

		do {
			userInputWord = ConsoleInput.readUserInput();
		} while (!WordValidator.validate(userInputWord, WORD_POOL));

		return userInputWord;
	}
}
