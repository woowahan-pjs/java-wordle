package wordle.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LetterTest {

	@ParameterizedTest
	@ValueSource(strings = {"ㅁ", "&"})
	@DisplayName("Letter 객체 생성시 알파벳이 아닌 값을 입력하면 오류가 발생한다")
	void invalidAlphabetInputTest(char alphabet) {
		// given & when & then
		assertThatIllegalArgumentException().isThrownBy(
			() -> new Letter(alphabet)
		);
	}
}
