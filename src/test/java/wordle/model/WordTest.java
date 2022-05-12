package wordle.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WordTest {

	@ParameterizedTest
	@ValueSource(strings = {"apple", "primm", "david", "jason"})
	@DisplayName("Word는 Letter 5개를 가지고 있다.")
	void wordShouldHaveFiveLetter(String userInput) {
		// given
		Word word = Word.from(userInput);

		// when
		int numberOfLetters = word.getLetters().length;

		// then
		int VALID_WORD_LENGTH = 5;
		assertThat(numberOfLetters).isEqualTo(VALID_WORD_LENGTH);
	}

	@ParameterizedTest
	@ValueSource(strings = {"#apple", "jason1", "우아한유스방"})
	void 유효하지_않은_단어가_입력되면_오류가_발생한다(String userInput) {
		// given & when & then
		assertThatIllegalArgumentException().
			isThrownBy(() -> Word.from(userInput));
	}

	@Test
	void 정답단어와_입력단어를_비교하여_글자가_같고_인덱스가_같으면_GREEN이다() {
		// given
		Word answerWord = Word.from("apple");
		Word inputWord = Word.from("apple");

		// when
		Tiles matchResult = answerWord.calculateMatched(inputWord);
		TileStatus[] tileStatuses = matchResult.getStatus();

		// then
		assertThat(tileStatuses[0]).isEqualTo(TileStatus.GREEN);
	}

	@Test
	void 정답단어와_입력단어를_비교하여_글자가_같고_인덱스가_다르면_YELLOW이다() {
		// given
		Word answerWord = Word.from("apple");
		Word inputWord = Word.from("water");

		// when
		Tiles matchResult = answerWord.calculateMatched(inputWord);
		TileStatus[] tileStatuses = matchResult.getStatus();

		// then
		assertThat(tileStatuses[1]).isEqualTo(TileStatus.YELLOW);
	}

	@Test
	void 정답단어와_입력단어를_비교하여_글자가_다르고_인덱스가_다르면_GRAY이다() {
		// given
		Word answerWord = Word.from("apple");
		Word inputWord = Word.from("water");

		// when
		Tiles matchResult = answerWord.calculateMatched(inputWord);
		TileStatus[] tileStatuses = matchResult.getStatus();

		// then
		assertThat(tileStatuses[0]).isEqualTo(TileStatus.GRAY);
	}
}
