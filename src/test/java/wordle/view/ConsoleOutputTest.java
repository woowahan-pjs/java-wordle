package wordle.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import wordle.Application;

public class ConsoleOutputTest extends NsTest {

	private static final String TODAY_ANSWER_MESSAGE = "오늘의 정답 단어는 story 입니다.";

	@Test
	void 정답_테스트() {
		assertSimpleTest(
			() -> {
				run("story");
				assertThat(output()).contains("🟩🟩🟩🟩🟩");
			}
		);
	}

	@Test
	void 정답을_맞추지_못한_경우의_테스트() {
		assertSimpleTest(
			() -> {
				run("world", "apple", "awake", "today", "daily", "table");
				assertThat(output()).contains(TODAY_ANSWER_MESSAGE);
			}
		);
	}

	@Override
	public void runMain() {
		Application.main(new String[]{});
	}
}
