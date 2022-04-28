package wordle.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LetterTest {

	@ParameterizedTest
	@CsvSource(value = {"ㅁ:1", "&:1"}, delimiter = ':')
	@DisplayName("Letter 객체 생성시 알파벳이 아닌 값을 입력하면 오류가 발생한다")
	void invalidAlphabetInputTest(char alphabet, int position) {
		// given & when & then
		assertThatIllegalArgumentException().isThrownBy(
			() -> new Letter(alphabet, position)
		);
	}

	@ParameterizedTest
	@CsvSource(value = {"a:0", "a:6", "a:-1"}, delimiter = ':')
	@DisplayName("Letter 객체 생성시 유효하지 않은 범위의 값을 입력하면 오류가 발생한다")
	void invalidPositionInputTest(char alphabet, int position) {
		// given & when & then
		assertThatIllegalArgumentException().isThrownBy(
			() -> new Letter(alphabet, position)
		);
	}
}
