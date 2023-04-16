package unit;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import woowaapplication.pair.game.wordle.WordleGameAnswerGenerator;

public class WordleGameAnswerGeneratorTest {
	private String 오늘의_정답_키워드 = "jason";

	private LocalDate 비교_날짜 = LocalDate.of(2021, 6, 24);

	@Nested
	@DisplayNameGeneration(ReplaceUnderscores.class)
	class 정답_생성_테스트 {

		@Nested
		@DisplayName("오늘의 날짜가 2021년 6월 24일이면")
		class Context_with_corrected_keyword {
			@Test
			@DisplayName("오늘의 정답 키워드는 jason이다")
			void it_returns_remaining_chance_and_answer() {
				String actual오늘의_정답_키워드 = WordleGameAnswerGenerator.getAnswerKeyword(비교_날짜);

				assertThat(오늘의_정답_키워드).isEqualTo(actual오늘의_정답_키워드);
			}
		}
	}

}
