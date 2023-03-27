package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Answer {
	private final List<Letter> answer;

	public Answer(List<Letter> answer) {
		this.answer = answer;
	}

	public List<MatchStatus> compare(List<Letter> letters) {
		List<MatchStatus> result = new ArrayList<>();
		for (Letter letter : letters) {
			result.add(this.match(letter));
		}
		return result;
	}

	private MatchStatus match(Letter letter) {
		if (!answer.contains(letter)) {
			return MatchStatus.GRAY;
		}
		if (letter.equals(answer.get(letter.getPosition()))) {
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

		Answer answer1 = (Answer)o;

		return Objects.equals(answer, answer1.answer);
	}

	@Override
	public int hashCode() {
		return answer != null ? answer.hashCode() : 0;
	}
}
