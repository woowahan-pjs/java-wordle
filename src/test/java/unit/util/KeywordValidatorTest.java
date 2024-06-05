package unit.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import woowaapplication.pair.game.util.KeywordValidator;
import woowaapplication.pair.game.wordle.exception.InvalidInputKeywordException;

class KeywordValidatorTest {

	@Nested
	@DisplayNameGeneration(ReplaceUnderscores.class)
	class 입력_검증_예외_케이스 {
		private final int LENGTH_LIMIT = 5;

		@Nested
		@DisplayName("알파벳이 아닌 입력이 들어오면")
		class Context_with_not_string_input {

			private final String 알파벳이_아닌_키워드 = "12345";

			@Test
			@DisplayName("시도가 무효된다")
			void it_makes_chance_canceled() {
				assertThatThrownBy(() -> KeywordValidator.validate(알파벳이_아닌_키워드, LENGTH_LIMIT)).isInstanceOf(
					InvalidInputKeywordException.class);
			}
		}

		@Nested
		@DisplayName("글자수 제한에 맞지 않는 입력이 들어오면")
		class Context_with_over_limit_input {

			private final String 글자수_제한에_맞지_않는_키워드 = "alexholden";

			@Test
			@DisplayName("시도가 무효된다")
			void it_makes_chance_canceled() {
				assertThatThrownBy(() -> KeywordValidator.validate(글자수_제한에_맞지_않는_키워드, LENGTH_LIMIT)).isInstanceOf(
					InvalidInputKeywordException.class);
			}
		}
	}
}
