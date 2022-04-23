package wordle.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ValidatorTest {

	@DisplayName("입력된 단어가 5글자가 아니면 재입력을 요청한다")
	@ParameterizedTest()
	@CsvSource({"a", "aa", "aaa", "aaaa", "aaaaaa"})
	void validateWordLength(String normalUserInput)
		throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		// given
		Validator validator = new Validator();
		Method method = validator.getClass().getDeclaredMethod("validateWordLength", String.class);
		method.setAccessible(true);

		// when
		boolean isValid = (boolean) method.invoke(validator, normalUserInput);

		// then
		Assertions.assertThat(isValid).isFalse();
	}

	@DisplayName("입력된 단어가 영단어가 아니면 재입력을 요청한다")
	@ParameterizedTest()
	@CsvSource({"1a2b3", "한글", "!@#ab", "AB 12"})
	void validateAlphabet(String normalUserInput)
		throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		// given
		Validator validator = new Validator();
		Method method = validator.getClass().getDeclaredMethod("validateAlphabet", String.class);
		method.setAccessible(true);

		// when
		boolean isValid = (boolean) method.invoke(validator, normalUserInput);

		// then
		Assertions.assertThat(isValid).isFalse();
	}
}
