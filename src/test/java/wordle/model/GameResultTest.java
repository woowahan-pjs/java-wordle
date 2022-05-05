package wordle.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import wordle.mock.MockWordPool;
import wordle.util.WordPoolGenerator;

public class GameResultTest {

	@ParameterizedTest
	@ValueSource(ints = {0, 1, 2, 3, 4, 5})
	void 입력기회_6번이_끝나기_전에_정답을_입력하면_참을_반환한다(int count) {
		// given
		MockWordPool wordPool = new MockWordPool(WordPoolGenerator.generate());

		// when
		Game game = new Game(wordPool);
		for (int i = 0; i < count; i++) {
			game.compareWith("apple");
		}
		game.compareWith("story");
		GameResult result = game.getResult();

		// then
		assertThat(result.isFinishedInTrying()).isTrue();
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4, 5, 6})
	void 입력기회_6번이_끝나기_전에_정답을_입력하지_못하면_거짓을_반환한다(int count) {
		// given
		MockWordPool wordPool = new MockWordPool(WordPoolGenerator.generate());

		// when
		Game game = new Game(wordPool);
		for (int i = 0; i < count; i++) {
			game.compareWith("apple");
		}
		GameResult result = game.getResult();

		// then
		assertThat(result.isFinishedInTrying()).isFalse();
	}

	@Test
	void 시도횟수가_6번이_끝나면_참을_반환한다() {
		// given
		MockWordPool wordPool = new MockWordPool(WordPoolGenerator.generate());

		// when
		Game game = new Game(wordPool);
		for (int i = 0; i < 6; i++) {
			game.compareWith("apple");
		}
		GameResult result = game.getResult();

		// then
		assertThat(result.isMaxCount()).isTrue();
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4, 5})
	void 시도횟수가_6번이_아니면_거짓을_반환한다(int count) {
		// given
		MockWordPool wordPool = new MockWordPool(WordPoolGenerator.generate());

		// when
		Game game = new Game(wordPool);
		for (int i = 0; i < count; i++) {
			game.compareWith("apple");
		}
		GameResult result = game.getResult();

		// then
		assertThat(result.isMaxCount()).isFalse();
	}

	@Test
	void 입력횟수가_6번째이고_정답을_입력한_경우_거짓을_반환한다() {
		// given
		MockWordPool wordPool = new MockWordPool(WordPoolGenerator.generate());

		// when
		Game game = new Game(wordPool);
		for (int i = 1; i <= 5; i++) {
			game.compareWith("apple");
		}
		game.compareWith("story");
		GameResult result = game.getResult();

		// then
		assertThat(result.isOverTrying()).isFalse();
	}

	@Test
	void 입력횟수가_6번째이고_정답을_입력하지_못한_경우_참을_반환한다() {
		// given
		MockWordPool wordPool = new MockWordPool(WordPoolGenerator.generate());

		// when
		Game game = new Game(wordPool);
		for (int i = 1; i <= 6; i++) {
			game.compareWith("apple");
		}
		GameResult result = game.getResult();

		// then
		assertThat(result.isOverTrying()).isTrue();
	}
}
