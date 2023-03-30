package domain;

import java.util.Objects;
import java.util.stream.Collectors;

public class Answer {
	private final Word answerWord;

	private Answer(Word answerWord) {
		this.answerWord = answerWord;
	}

	public static Answer from(String input) {
		return new Answer(Word.from(input));
	}

	public Result compare(Word word) {
		return word.getLetters().stream()
			.map(this::match)
			.collect(Collectors.collectingAndThen(Collectors.toList(), Result::new));
	}

	private MatchStatus match(Letter letter) {
		if (!answerWord.contains(letter)) {
			return MatchStatus.GRAY;
		}
		if (letter.equals(answerWord.get(letter.getPosition()))) {
			return MatchStatus.GREEN;
		}
		return MatchStatus.YELLOW;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Answer answer = (Answer)o;

		return Objects.equals(answerWord, answer.answerWord);
	}

	@Override
	public int hashCode() {
		return answerWord != null ? answerWord.hashCode() : 0;
	}
}
