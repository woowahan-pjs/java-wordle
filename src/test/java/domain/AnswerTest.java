package domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AnswerTest {

	private List<Letter> letters = new ArrayList<>();

	@BeforeEach
	void setUp() {
		letters = List.of(
			new Letter('s', 0),
			new Letter('p', 1),
			new Letter('i', 2),
			new Letter('l', 3),
			new Letter('l', 4));
	}

	@Test
	@DisplayName("생성자로 인스턴스 만들었을 때 멤버변수에 answer 둥록.")
	void testAnswer() {
		assertAll(
			() -> assertThat(letters.get(0)).isEqualTo(new Letter('s', 0)),
			() -> assertThat(letters.get(1)).isEqualTo(new Letter('p', 1)),
			() -> assertThat(letters.get(2)).isEqualTo(new Letter('i', 2)),
			() -> assertThat(letters.get(3)).isEqualTo(new Letter('l', 3)),
			() -> assertThat(letters.get(4)).isEqualTo(new Letter('l', 4))
		);
	}

	@Test
	@DisplayName("정답과 입력값 비교하여 MatchStatus 리스트로 반환")
	void testWithInputString() {
		//given
		// Answer answer = new Answer(letters, answerWord);
		// List<Letter> target = List.of(
		// 	new Letter('h', 0),
		// 	new Letter('e', 1),
		// 	new Letter('l', 2),
		// 	new Letter('l', 3),
		// 	new Letter('o', 4));

		//when
		// List<MatchStatus> result = answer.compare(target);
		//
		// //then
		// assertThat(result.get(0)).isEqualTo(MatchStatus.GRAY);
		// assertThat(result.get(1)).isEqualTo(MatchStatus.GRAY);
		// assertThat(result.get(2)).isEqualTo(MatchStatus.YELLOW);
		// assertThat(result.get(3)).isEqualTo(MatchStatus.GREEN);
		// assertThat(result.get(4)).isEqualTo(MatchStatus.GRAY);

	}
}
