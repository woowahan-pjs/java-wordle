package wordle.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import wordle.model.WordPool;

class WordValidatorTest {

	WordPool wordPool = new WordPool(WordPoolGenerator.generate());

	@ParameterizedTest
	@ValueSource(strings = {"", "a", "du", "test", "jaason"})
	void 유효하지_않은_길이의_단어가_입력되면_오류를_반환한다(String userInput) {
		// given & when & then
		assertThatIllegalArgumentException().
			isThrownBy(() -> WordValidator.validate(userInput, wordPool))
			.withMessageContaining("단어는 5글자로 구성되어야 합니다.");
	}

	@ParameterizedTest
	@ValueSource(strings = {"%@$%#", "두두제이슨"})
	void 영단어가_아닌_값이_입력되면_오류를_반환한다(String userInput) {
		// given & when & then
		assertThatIllegalArgumentException().
			isThrownBy(() -> WordValidator.validate(userInput, wordPool))
			.withMessageContaining("단어는 영문자로 구성되어야 합니다.");
	}

	@ParameterizedTest
	@ValueSource(strings = {"jason", "david", "books"})
	void words_파일에_없는_값이_입력되면_오류를_반환한다(String userInput) {
		// given & when & then
		assertThatIllegalArgumentException().
			isThrownBy(() -> WordValidator.validate(userInput, wordPool))
			.withMessageContaining("존재하지 않는 단어입니다.");
	}
}
