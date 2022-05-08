package wordle.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WordValidatorTest {

	private static final String VALID_WORDS_TEXT_FILE_PATH = "src/test/resources/words.txt";

	@ParameterizedTest
	@ValueSource(chars = {'0', '!', 'ㅁ', 'な', '圓'})
	@DisplayName("영문자가 아닌 문자는 유효하지 않다")
	void Non_english_alphabet_is_invalid(char character) {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> WordValidator.validateEnglishAlphabet(character))
			.withMessage(Message.INVALID_ENGLISH_ALPHABET_MESSAGE);
	}

	@ParameterizedTest()
	@ValueSource(strings = {"a", "ab", "abc", "abcd", "abcdef"})
	@DisplayName("5글자가 아닌 단어는 유효하지 않다")
	void Word_has_not_five_letter_is_invalid(String word) {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> WordValidator.validateFiveLetterWord(word))
			.withMessage(Message.INVALID_ENGLISH_ALPHABET_MESSAGE);
	}

	@ParameterizedTest()
	@ValueSource(strings = {"aaaaa", "bbbbb", "ccccc", "ddddd", "eeeee"})
	@DisplayName("단어 목록에 존재하지 않는 단어는 유효하지 않다")
	void It_is_invalid_that_word_is_not_in_word_pool(String wordInWordPool) {
		WordPool wordPool = WordPoolGenerator.generateFromFile(VALID_WORDS_TEXT_FILE_PATH);
		assertThatIllegalArgumentException()
			.isThrownBy(() -> WordValidator.isValid(wordInWordPool, wordPool))
			.withMessage(Message.INVALID_WORD_MESSAGE);
	}

	@ParameterizedTest()
	@ValueSource(strings = {"1aaaa", "b!bbb", "ccㅁcc", "dddなd", "eeee圓"})
	@DisplayName("단어는 영문자로만 구성되어야 한다")
	void Word_has_only_english_letter(String wrongWord) {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> WordValidator.validateEnglishLetterOnly(wrongWord))
			.withMessage(Message.INVALID_WORD_LENGTH_MESSAGE);
	}
}
