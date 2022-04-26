package wordle.model;

import java.util.Collections;
import java.util.List;

public class WordPool {

	private final List<String> words;

	public WordPool(List<String> words) {
		this.words = Collections.unmodifiableList(words);
	}

	public String getTodayAnswerWord(int index) {
		return words.get(index);
	}

	public boolean contains(String word) {
		return words.contains(word);
	}

	public int size() {
		return words.size();
	}
}
