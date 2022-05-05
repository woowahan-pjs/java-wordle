package wordle.controller;

import wordle.model.Game;
import wordle.model.GameStatus;
import wordle.model.WordPool;
import wordle.util.WordPoolGenerator;
import wordle.util.WordValidator;
import wordle.view.ConsoleInput;
import wordle.view.ConsoleOutput;

public class WordleMachine {

	private static final WordPool WORD_POOL = new WordPool(WordPoolGenerator.generate());
	private final ConsoleInput consoleInput = new ConsoleInput();
	private final ConsoleOutput consoleOutput = new ConsoleOutput();

	public void startGame() {
		Game game = new Game(WORD_POOL);
		consoleOutput.printGameStartMessage();
		while (game.getGameStatus() == GameStatus.PROGRESS) {
			game.compareWith(readValidUserInput());
			consoleOutput.printGameResultMessage(game.getResult(), game.getAnswer());
		}
	}

	private String readValidUserInput() {
		String userInputWord;

		do {
			userInputWord = consoleInput.readUserInput();
		} while (!WordValidator.validate(userInputWord, WORD_POOL));

		return userInputWord;
	}
}
