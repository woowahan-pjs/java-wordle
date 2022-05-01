package wordle.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import wordle.model.WordPool;

class WordPoolGeneratorTest {

	private static final String VALID_WORDS_TEXT_FILE_PATH = "src/test/resources/words.txt";
	private static final String INVALID_WORDS_TEXT_FILE_PATH = "src/test/resources/invalidWords.txt";

	@Test
	@DisplayName("words.txt 파일의 추출로 가져온 단어의 갯수는 0보다 크다")
	void wordsGeneratorTest() {
		// given & when
		WordPool wordList = WordPoolGenerator.generate(VALID_WORDS_TEXT_FILE_PATH);
		int wordListSize = wordList.size();

		// then
		assertThat(wordListSize).isPositive();
	}

	@Test
	@DisplayName("invalidWords.txt 파일의 추출로 가져온 단어의 갯수는 0이다")
	void validWordLengthTest() {
		// 유효하지 않은 길이의 단어를 가지고 있는 파일을 검증하기 위해서 어떤 방법이 좋은지?
		// 1. 미리 만들어진 테스트용 파일(유효하지 않은 단어 목록)을 사용한다.
		// 2. 테스트 내에서 테스트용 파일(유효하지 않은 단어 목록)을 만들어 사용한다.
		// 3. 테스트 내에서 이미 만들어진 테스트용 파일을 읽어 온 결과와 객체(WordPoolGenerator)로부터 만들어진 결과를 비교한다.
		// given & when
		WordPool wordList = WordPoolGenerator.generate(INVALID_WORDS_TEXT_FILE_PATH);
		int wordListSize = wordList.size();

		// then
		assertThat(wordListSize).isZero();
	}
}
