package wordle.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WordsGeneratorTest {

	@Test
	@DisplayName("words.txt 파일의 추출로 가져온 단어의 갯수는 0보다 커야한다")
	void wordsGeneratorTest() {
		// given & when
		List<String> wordList = WordsGenerator.generate();
		int wordListSize = wordList.size();

		// then
		assertThat(wordListSize).isPositive();
	}
}
