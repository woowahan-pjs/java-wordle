package wordle.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LetterTest {

	@ParameterizedTest
	@ValueSource(strings = {"ㅁ", "&"})
	@DisplayName("영문자가 아닌 문자로 Letter 를 생성할 수 없다")
	void Letter_with_non_english_letter_is_invalid(char alphabet) {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new Letter(alphabet))
			.withMessage(Message.INVALID_ENGLISH_ALPHABET_MESSAGE);
	}

	@ParameterizedTest
	@ValueSource(strings = {"A", "B"})
	@DisplayName("Letter 는 영어 소문자만 가진다")
	void Letter_has_only_lower_case(String alphabet) {
		Letter letter = new Letter(alphabet.toCharArray()[0]);
		char alphabetLowerCase = alphabet.toLowerCase().toCharArray()[0];

		assertThat(letter.getAlphabet()).isEqualTo(alphabetLowerCase);
	}
}
