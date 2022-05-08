package wordle.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WordPoolGeneratorTest {

	private static final String VALID_WORDS_TEXT_FILE_PATH = "src/test/resources/words.txt";
	private static final String INVALID_WORDS_TEXT_FILE_PATH = "src/test/resources/invalidWords.txt";
	private static final String NOT_EXISTED_TEXT_FILE_PATH = "src/test/resources/notExistedFile.txt";
	private static final String NOT_EXISTED_WORD_IN_FILE_MESSAGE = "파일에 단어가 존재하지 않습니다.";
	private static final String NO_SUCH_FILE_MESSAGE = "존재하지 않는 파일입니다.";

	@Test
	@DisplayName("기본 파일로부터 단어 목록이 생성된다")
	void words_are_generated_from_default_file() {
		assertThat(WordPoolGenerator.generateFromDefaultFile()).isNotNull();
	}

	@Test
	@DisplayName("지정한 파일로부터 단어 목록이 생성된다")
	void words_are_generated_from_file() {
		assertThat(WordPoolGenerator.generateFromFile(VALID_WORDS_TEXT_FILE_PATH)).isNotNull();
	}

	@Test
	@DisplayName("존재하지 않는 파일로 단어 목록을 생성할 때 예외가 발생한다")
	void throwExceptionFromNotExistedFilePath() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> WordPoolGenerator.generateFromFile(NOT_EXISTED_TEXT_FILE_PATH))
			.withMessage(NO_SUCH_FILE_MESSAGE);
	}

	@Test
	@DisplayName("단어 목록에 5글자인 단어가 1개이상 존재해야 한다")
	void throwExceptionFromNotExistedValidLengthWords() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> WordPoolGenerator.generateFromFile(INVALID_WORDS_TEXT_FILE_PATH))
			.withMessage(NOT_EXISTED_WORD_IN_FILE_MESSAGE);
	}
}
