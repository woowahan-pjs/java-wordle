package wordle.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {

	private static final ManipulatedWordPool manipulatedWordPool = new ManipulatedWordPool();

	@Test
	@DisplayName("시도 횟수 내 정답을 맞추면 게임은 종료된다")
	void Game_is_over_with_correcting_answer_in_trying_count() {
		WordPool wordPool = WordPoolGenerator.generateFromDefaultFile();
		Game game = new Game(wordPool);
		String todayAnswerWord = wordPool.getTodayAnswerWord();

		game.progressTurn(todayAnswerWord);

		assertThat(game.isFinish()).isTrue();
	}

	@Test
	@DisplayName("시도 횟수 내 정답을 맞추지 못하면 게임은 종료된다")
	void Game_is_over_with_over_trying_count() {
		Game game = new Game(manipulatedWordPool);
		String wrongAnswerWord = "alone";
		int MAXIMUM_TRYING_COUNT = 6;

		for (int count = 0; count < MAXIMUM_TRYING_COUNT; count++) {
			game.progressTurn(wrongAnswerWord);
		}

		assertThat(game.isFinish()).isTrue();
	}

	@Test
	@DisplayName("게임을 시작하면 게임 시작 액션이 반환된다")
	void Game_start_returns_game_start_action() {
		Game game = new Game(manipulatedWordPool);

		GameAction gameAction = game.start();

		assertThat(gameAction).isInstanceOf(GameStartAction.class);
	}

	/**
	 * 정답을 조작하기 위한 클래스
	 */
	static class ManipulatedWordPool implements WordPool {

		@Override
		public String getTodayAnswerWord() {
			return "apple";
		}

		@Override
		public boolean contains(String word) {
			return false;
		}
	}
}
