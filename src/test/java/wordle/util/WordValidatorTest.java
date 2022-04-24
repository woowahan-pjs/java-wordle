package wordle.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WordValidatorTest {

	@DisplayName("입력된 단어가 5글자가 아니면 재입력을 요청한다")
	@ParameterizedTest()
	@CsvSource({"a", "aa", "aaa", "aaaa", "aaaaaa"})
	void validateWordLength(String normalUserInput)
		throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		// given
		WordValidator wordValidator = new WordValidator();
		Method method = wordValidator.getClass().getDeclaredMethod("validateWordLength", String.class);
		method.setAccessible(true);

		// when
		boolean isValid = (boolean) method.invoke(wordValidator, normalUserInput);

		// then
		assertThat(isValid).isFalse();
	}

	@DisplayName("입력된 단어가 영단어가 아니면 재입력을 요청한다")
	@ParameterizedTest()
	@CsvSource({"1a2b3", "한글", "!@#ab", "AB 12"})
	void validateAlphabet(String normalUserInput)
		throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		// given
		WordValidator wordValidator = new WordValidator();
		Method method = wordValidator.getClass().getDeclaredMethod("validateAlphabet", String.class);
		method.setAccessible(true);

		// when
		boolean isValid = (boolean) method.invoke(wordValidator, normalUserInput);

		// then
		assertThat(isValid).isFalse();
	}

	@DisplayName("입력된 단어가 단어 목록에 없으면 실패이다")
	@ParameterizedTest()
	@CsvSource({"jason", "nosaj", "primm", "david"})
	void validateNotExistedWord(String normalUserInput)
		throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		// given
		List<String> wordList = Arrays.asList("disco", "jelly", "table", "alert");
		WordValidator wordValidator = new WordValidator();
		Method method = wordValidator.getClass().getDeclaredMethod("validateExistedWord", String.class, List.class);
		method.setAccessible(true);

		// when
		boolean isValid = (boolean) method.invoke(wordValidator, normalUserInput, wordList);

		// then
		assertThat(isValid).isFalse();
	}

	@DisplayName("입력된 단어가 단어 목록에 존재하면 성공이다")
	@ParameterizedTest()
	@CsvSource({"disco", "jelly", "table", "alert"})
	void validateExistedWord(String normalUserInput)
		throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		// given
		List<String> wordList = Arrays.asList("disco", "jelly", "table", "alert");
		WordValidator wordValidator = new WordValidator();
		Method method = wordValidator.getClass().getDeclaredMethod("validateExistedWord", String.class, List.class);
		method.setAccessible(true);

		// when
		boolean isValid = (boolean) method.invoke(wordValidator, normalUserInput, wordList);

		// then
		assertThat(isValid).isTrue();
	}
}
