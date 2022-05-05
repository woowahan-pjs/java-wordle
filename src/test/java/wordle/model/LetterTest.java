package wordle.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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

	@ParameterizedTest
	@CsvSource(value = {"a:0", "p:1", "p:2", "l:3", "e:4"}, delimiter = ':')
	void 단어_입력시_Letter_객체에_알파벳이_저장된다(char alphabet, int index) {
		// given
		String input = "apple";
		Word answer = new Word(input);

		// when
		Letter[] alphabetList = answer.getLetters();

		// then
		assertThat(alphabetList[index].getAlphabet()).isEqualTo(alphabet);
	}

	@ParameterizedTest
	@ValueSource(strings = {"apple", "world"})
	void Letter_객체는_단어를_가지고_있다(String input) {
		// given
		Word answer = new Word(input);

		// when
		String letters = answer.getAnswerWordAsString();

		// then
		assertThat(letters).isEqualTo(input);
	}

	@Test
	void 정답_단어와_입력된_단어를_비교한_결과_일치하면_참이다() {
		// given
		String input = "apple";
		Word answer = new Word(input);
		Word inputWord = new Word(input);

		// when
		answer.calculateMatched(inputWord);
		boolean matchedResult = answer.getLetters()[0].isMatched();

		// then
		assertThat(matchedResult).isTrue();
	}

	@Test
	void 정답_단어와_입력된_단어를_비교한_결과_일치하지_않으면_거짓이다() {
		// given
		Word answer = new Word("world");
		Word userInput = new Word("apple");

		// when
		answer.calculateMatched(userInput);
		boolean matchedResult = answer.getLetters()[0].isMatched();

		// then
		assertThat(matchedResult).isFalse();
	}
}
