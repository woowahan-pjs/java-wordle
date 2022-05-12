package wordle.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import wordle.mock.MockWordPool;
import wordle.util.WordPoolGenerator;

public class GameTest {

	@Test
	void game_객체는_정답_단어를_가지고_있다() {
		// given
		MockWordPool wordPool = new MockWordPool(WordPoolGenerator.generate());

		// when
		Game game = new Game(wordPool);
		Word answer = Word.from(wordPool.getTodayAnswerWord());

		// then
		assertThat(game.getAnswer()).isEqualTo(answer);
	}

	@ParameterizedTest
	@MethodSource("parameterProvider")
	void game_객체는_오늘의_정답과_입력된_정답을_비교한_결과를_가지고_있다(String userInput, TileStatus[] result) {
		// given
		MockWordPool wordPool = new MockWordPool(WordPoolGenerator.generate());

		// when
		Game game = new Game(wordPool);
		game.compareWith(userInput);
		TileStatus[] answer = game.getResult().getTilesList().get(0).getStatus();

		// then
		assertThat(answer).isEqualTo(result);
	}

	@ParameterizedTest
	@MethodSource("parameterProvider2")
	void 답을_입력한_횟수와_game_객체가_가지고_있는_시도_횟수가_같다(String[] userInputList, int length) {
		// given
		MockWordPool wordPool = new MockWordPool(WordPoolGenerator.generate());

		// when
		Game game = new Game(wordPool);
		for (String userInput : userInputList) {
			game.compareWith(userInput);
		}

		int userTryingCount = game.getResult().getTryingCount();

		// then
		assertThat(userTryingCount).isEqualTo(length);
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 1, 2, 3, 4, 5})
	void 입력기회_6번이_끝나기_전에_정답을_입력하면_게임의_상태가_WIN이다(int count) {
		// given
		MockWordPool wordPool = new MockWordPool(WordPoolGenerator.generate());

		// when
		Game game = new Game(wordPool);
		for (int i = 0; i < count; i++) {
			game.compareWith("apple");
		}
		game.compareWith("story");

		// then
		assertThat(game.getGameStatus()).isEqualTo(GameStatus.WIN);
	}

	@Test
	void 오답을_6번_입력하면_게임의_상태가_LOSE이다() {
		// given
		MockWordPool wordPool = new MockWordPool(WordPoolGenerator.generate());

		// when
		Game game = new Game(wordPool);
		for (int i = 0; i < 6; i++) {
			game.compareWith("apple");
		}

		// then
		assertThat(game.getGameStatus()).isEqualTo(GameStatus.LOSE);
	}

	private static Stream<Arguments> parameterProvider() {
		return Stream.of(
			Arguments.arguments("story",
				new TileStatus[]{TileStatus.GREEN, TileStatus.GREEN, TileStatus.GREEN, TileStatus.GREEN,
					TileStatus.GREEN}),
			Arguments.arguments("style",
				new TileStatus[]{TileStatus.GREEN, TileStatus.GREEN, TileStatus.YELLOW, TileStatus.GRAY,
					TileStatus.GRAY})
		);
	}

	private static Stream<Arguments> parameterProvider2() {
		return Stream.of(
			Arguments.arguments(new String[]{"apple"}, 1),
			Arguments.arguments(new String[]{"apple", "world"}, 2),
			Arguments.arguments(new String[]{"apple", "world", "story"}, 3)
		);
	}
}
