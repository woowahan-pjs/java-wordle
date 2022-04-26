package wordle.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import wordle.model.WordPool;

class WordPoolGeneratorTest {

	@Test
	@DisplayName("words.txt 파일의 추출로 가져온 단어의 갯수는 0보다 커야한다")
	void wordsGeneratorTest() {
		// given & when
		WordPool wordList = WordPoolGenerator.generate();
		int wordListSize = wordList.size();

		// then
		assertThat(wordListSize).isPositive();
	}
}
