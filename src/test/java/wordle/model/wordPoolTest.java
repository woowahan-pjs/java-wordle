package wordle.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import wordle.mock.MockWordPool;
import wordle.util.WordPoolGenerator;

public class wordPoolTest {

	@Test
	void WordPool에서_오늘의_정답_단어를_반환한다() {
		// given
		MockWordPool wordPool = new MockWordPool(WordPoolGenerator.generate());
		String answerWord = wordPool.getTodayAnswerWord();

		assertThat(answerWord).isNotEmpty();
	}
}
