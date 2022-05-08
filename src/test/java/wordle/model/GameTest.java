package wordle.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {

	@Test
	@DisplayName("시도 횟수 내 정답을 맞추면 게임은 종료된다")
	void Game_is_over_with_correcting_answer_in_trying_count() {
		WordPool wordPool = WordPoolGenerator.generateFromDefaultFile();
		Game game = new Game(wordPool);
		String todayAnswerWord = wordPool.getTodayAnswerWord();

		game.progressTurn(todayAnswerWord);

		assertThat(game.isFinish()).isTrue();
	}
}
