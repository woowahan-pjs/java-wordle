package domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AnswerTest {

	private Word word;

	@BeforeEach
	void setUp() {
		word = Word.from("spill");
	}

	@Test
	@DisplayName("생성자로 인스턴스 만들었을 때 멤버변수에 answer 둥록.")
	void testAnswer() {
		assertAll(
			() -> assertThat(word.get(0)).isEqualTo(new Letter('s', 0)),
			() -> assertThat(word.get(1)).isEqualTo(new Letter('p', 1)),
			() -> assertThat(word.get(2)).isEqualTo(new Letter('i', 2)),
			() -> assertThat(word.get(3)).isEqualTo(new Letter('l', 3)),
			() -> assertThat(word.get(4)).isEqualTo(new Letter('l', 4))
		);
	}

	@Test
	@DisplayName("정답과 입력값 비교하여 MatchStatus 리스트로 반환")
	void testWithInputString() {
		 //given
		 Answer answer = Answer.from("spill");
		 Word target = Word.from("hello");

		//when
		 List<MatchStatus> result = answer.compare(target);

		 //then
		 assertThat(result.get(0)).isEqualTo(MatchStatus.GRAY);
		 assertThat(result.get(1)).isEqualTo(MatchStatus.GRAY);
		 assertThat(result.get(2)).isEqualTo(MatchStatus.YELLOW);
		 assertThat(result.get(3)).isEqualTo(MatchStatus.GREEN);
		 assertThat(result.get(4)).isEqualTo(MatchStatus.GRAY);

	}
}
