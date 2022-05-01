package wordle.controller;

import wordle.model.Game;
import wordle.model.WordPool;
import wordle.util.WordPoolGenerator;
import wordle.util.WordValidator;
import wordle.view.ConsoleInput;
import wordle.view.ConsoleOutput;

public class WordleMachine {

	private static final WordPool WORD_POOL = WordPoolGenerator.generate(WordPoolGenerator.WORDS_TEXT_FILE_PATH);
	private final ConsoleInput consoleInput = new ConsoleInput();
	private final ConsoleOutput consoleOutput = new ConsoleOutput();

	public void startGame() {
		Game game = new Game(WORD_POOL);
		consoleOutput.printGameStartMessage();
 		while (!game.isFinish()) {
			game.compareWith(readValidUserInput());
			consoleOutput.printGameResultMessage(game.getResult());
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
