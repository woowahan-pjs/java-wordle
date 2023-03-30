package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Answer {
	private final Word answerWord;

	private Answer(Word answerWord) {
		this.answerWord = answerWord;
	}

	public static Answer from(String input) {
		return new Answer(Word.from(input));
	}

	public List<MatchStatus> compare(List<Letter> letters) {
		List<MatchStatus> result = new ArrayList<>();
		for (Letter letter : letters) {
			result.add(this.match(letter));
		}
		return result;
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
