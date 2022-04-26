package wordle.model;

import java.util.ArrayList;
import java.util.List;

public class Word {

	private List<Letter> letters = new ArrayList<>();

	public Word(String input) {
		createLetters(input);
	}

	public List<Letter> getLetters() {
		return letters;
	}

	private void createLetters(String input) {
		for (int index = 0; index < input.length(); index++) {
			letters.add(new Letter(input.charAt(index), index + 1));
		}
	}

	public List<Tile> compareWith(Word userInputWord) {
		List<Tile> result = new ArrayList<>();
		for (Letter letter : userInputWord.getLetters()) {
			result.add(new Tile(letter.compareResult(letters)));
		}
		return result;
	}
}
