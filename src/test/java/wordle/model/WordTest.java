package wordle.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WordTest {

	@ParameterizedTest
	@ValueSource(strings = {"apple", "primm", "david", "jason"})
	@DisplayName("Word는 Letter 5개를 가지고 있다.")
	void wordShouldHaveFiveLetter(String userInput) {
		// given
		Word word = new Word(userInput);

		// when
		int numberOfLetters = word.getLetters().size();

		// then
		int VALID_WORD_LENGTH = 5;
		assertThat(numberOfLetters).isEqualTo(VALID_WORD_LENGTH);
	}
}
