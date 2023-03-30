package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Word {

	private List<Letter> letters;

	private Word(List<Letter> letters) {
		this.letters = letters;
	}

	public static Word from(String input) {
		validate(input);
		char[] chars = input.toCharArray();
		List<Letter> letterList = new ArrayList<>();
		for (int i = 0; i < chars.length; i++) {
			letterList.add(new Letter(chars[i], i));
		}
		return new Word(letterList);
	}

	private static void validate(String input) {
		validateNullAndEmpty(input);
		validateLength(input);
	}

	private static void validateNullAndEmpty(String input) {
		if (input == null || input.isBlank()) {
			throw new IllegalArgumentException("단어는 빈 값일 수 없습니다.");
		}
	}

	private static void validateLength(String input) {
		if (input.length() != 5) {
			throw new IllegalArgumentException("단어는 5글자여야 합니다. | input :" + input);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Word word = (Word)o;

		return Objects.equals(letters, word.letters);
	}

	@Override
	public int hashCode() {
		return letters != null ? letters.hashCode() : 0;
	}
}
