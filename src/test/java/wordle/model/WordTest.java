package wordle.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WordTest {

	@ParameterizedTest
	@ValueSource(strings = {"apple", "primm", "david", "jason"})
	@DisplayName("Word는 Letter를 5개 가져야 한다")
	void Word_has_five_letter(String userInput) {
		int VALID_WORD_LENGTH = 5;
		Word word = new Word(userInput);

		int numberOfLetters = word.getLetters().length;

		assertThat(numberOfLetters).isEqualTo(VALID_WORD_LENGTH);
	}

	@Test
	@DisplayName("사용자가 입력한 글자와 그 위치가 정답 단어의 글자와 그 위치와 동일하면 초록색 타일을 포함한 결과를 반환한다")
	void Same_letter_and_position_in_answer_word_returns_green_tile() {
		Word userInputWord = new Word("aaaaa");
		Word answerWord = new Word("aaaaa");

		TileLine tileLine = userInputWord.match(answerWord);
		TileStatus[] tileStatuses = tileLine.getTileStatuses();

		assertThat(hasTile(tileStatuses, TileStatus.GREEN)).isTrue();
	}

	@Test
	@DisplayName("사용자가 입력한 글자가 정답 단어에 존재하지 않으면 회색 타일을 포함한 결과를 반환한다")
	void Not_existed_letter_in_answer_word_returns_gray_tile() {
		Word userInputWord = new Word("bbbbb");
		Word answerWord = new Word("aaaaa");

		TileLine tileLine = userInputWord.match(answerWord);
		TileStatus[] tileStatuses = tileLine.getTileStatuses();

		assertThat(hasTile(tileStatuses, TileStatus.GRAY)).isTrue();
	}

	@Test
	@DisplayName("사용자가 입력한 글자가 정답 단어에 존재하지만 위치가 일치하지 않으면 노란색 타일을 포함한 결과를 반환한다")
	void e() {
		Word userInputWord = new Word("abbbb");
		Word answerWord = new Word("bbbba");

		TileLine tileLine = userInputWord.match(answerWord);
		TileStatus[] tileStatuses = tileLine.getTileStatuses();

		assertThat(hasTile(tileStatuses, TileStatus.YELLOW)).isTrue();
	}

	/**
	 * 타일 목록에 특정 타일이 포함되어있는지 확인한다
	 *
	 * @param tileStatuses
	 * @param tileStatus
	 * @return
	 */
	private boolean hasTile(TileStatus[] tileStatuses, TileStatus tileStatus) {
		for (TileStatus status : tileStatuses) {
			if (status == tileStatus) {
				return true;
			}
		}
		return false;
	}
}
