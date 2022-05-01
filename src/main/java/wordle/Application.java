package wordle;

import wordle.controller.WordleMachine;

public class Application {
	public static void main(String[] args) {
		WordleMachine wordleMachine = new WordleMachine();
		wordleMachine.startGame();
	}
}
