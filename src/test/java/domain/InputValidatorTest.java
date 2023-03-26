package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

	@DisplayName("글자가 모두 영어이면 true 반환 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"abc", "test", "wordle"})
	void letterWithOnlyEnglishTest(String input) {
		assertThat(new InputValidator().validateEnglish(input)).isTrue();
	}

	@DisplayName("글자에 숫자가 포함되면 false 반환 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"1bac", "abc123", "00000", "t2e5st9"})
	void letterWithNumberTest(String input) {
		assertThat(new InputValidator().validateEnglish(input)).isFalse();
	}

	@DisplayName("글자에 특수문자가 포함되면 false 반환 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"!test", "t@s&s,t", "!$%$^&#^!,."})
	void letterWithSpecialCharacterTest(String input) {
		assertThat(new InputValidator().validateEnglish(input)).isFalse();
	}

	@DisplayName("글자에 한글에 포함되면 false 반환 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"안녕하세요", "t테e스s트t", "abkㅁㄴㅇㄹ"})
	void letterWithKoreanLetterTest(String input) {
		assertThat(new InputValidator().validateEnglish(input)).isFalse();
	}

	@DisplayName("입력한 글자가 5글자면 true 반환 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"words", "tests", "abcde", "qwert"})
	void letterWithFiveLettersTest(String input) {
		assertThat(new InputValidator().validateEnglish(input)).isTrue();
	}

	@DisplayName("입력한 글자가 5글자가 아니면 false 반환 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"word", "t", "abcdefg", "lrkagrlkgnalkf"})
	void letterWithNotFiveLettersTest(String input) {
		assertThat(new InputValidator().validateLength(input)).isFalse();
	}

	@DisplayName("입력한 글자에 공백이 포함되면 false 반환 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"abc  ", "ab cd", "    b"})
	void letterWithBlankTest(String input) {
		assertThat(new InputValidator().validateEnglish(input)).isFalse();
	}
}
