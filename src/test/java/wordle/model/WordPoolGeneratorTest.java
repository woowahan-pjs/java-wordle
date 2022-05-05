package wordle.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WordPoolGeneratorTest {

	private static final String VALID_WORDS_TEXT_FILE_PATH = "src/test/resources/words.txt";
	private static final String INVALID_WORDS_TEXT_FILE_PATH = "src/test/resources/invalidWords.txt";
	private static final String NOT_EXISTED_TEXT_FILE_PATH = "src/test/resources/notExistedFile.txt";

	@Test
	@DisplayName("기본 파일로부터 단어 목록이 생성된다")
	void words_are_generated_from_default_file() {
		WordPool wordPool = WordPoolGenerator.generateFromDefaultFile();
		int wordPoolSize = wordPool.size();

		assertThat(wordPoolSize).isPositive();
	}

	@Test
	@DisplayName("파일로부터 단어 목록이 생성된다")
	void words_are_generated_from_file() {
		WordPool wordPool = WordPoolGenerator.generateFromFile(VALID_WORDS_TEXT_FILE_PATH);
		int wordPoolSize = wordPool.size();

		assertThat(wordPoolSize).isPositive();
	}

	@Test
	@DisplayName("존재하지 않는 파일로 단어 목록을 생성할 때 예외가 발생한다")
	void throwExceptionFromNotExistedFilePath() {
		assertThatIllegalArgumentException().
			isThrownBy(() -> WordPoolGenerator.generateFromFile(NOT_EXISTED_TEXT_FILE_PATH));
	}

	@Test
	@DisplayName("5글자로 구성된 단어가 1개이상 존재하지 않으면 예외가 발생한다")
	void throwExceptionFromNotExistedValidLengthWords() {
		assertThatIllegalArgumentException().
			isThrownBy(() -> WordPoolGenerator.generateFromFile(INVALID_WORDS_TEXT_FILE_PATH));
	}
}
