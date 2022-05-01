package wordle.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import wordle.model.WordPool;

class WordPoolGeneratorTest {

	private static final String VALID_WORDS_TEXT_FILE_PATH = "src/test/resources/words.txt";
	private static final String INVALID_WORDS_TEXT_FILE_PATH = "src/test/resources/invalidWords.txt";
	private static final String NOT_EXISTED_TEXT_FILE_PATH = "src/test/resources/notExistedFile.txt";

	@Test
	@DisplayName("기본 파일 경로로부터 단어 목록이 생성된다")
	void wordsGenerateWithInternalDefaultFilePath() {
		// given & when
		WordPool wordList = WordPoolGenerator.generate();
		int wordListSize = wordList.size();

		// then
		assertThat(wordListSize).isPositive();
	}

	@Test
	@DisplayName("외부 파일 경로로부터 단어 목록이 생성된다")
	void wordsGenerateWithExternalFilePath() {
		// given & when
		WordPool wordList = WordPoolGenerator.generate(VALID_WORDS_TEXT_FILE_PATH);
		int wordListSize = wordList.size();

		// then
		assertThat(wordListSize).isPositive();
	}

	@Test
	@DisplayName("존재하지 않는 파일의 경로로 단어 목록을 생성하려고 하면 예외가 발생한다")
	void throwExceptionFromNotExistedFilePath() {
		// given & when & then
		assertThatIllegalArgumentException().
			isThrownBy(() -> WordPoolGenerator.generate(NOT_EXISTED_TEXT_FILE_PATH));
	}

	@Test
	@DisplayName("5글자로 구성된 단어가 1개라도 존재하지 않으면 예외가 발생한다")
	void throwExceptionFromNotExistedValidLengthWords() {
		// given & when & then
		assertThatIllegalArgumentException().
			isThrownBy(() -> WordPoolGenerator.generate(INVALID_WORDS_TEXT_FILE_PATH));
	}
}
