package wordle.infrastructure.ui;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.List;

import wordle.domain.word.WordCondition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConsoleUITest {

    private ConsoleUI adapter;

    @BeforeEach
    void setUp() {
        adapter = new ConsoleUI();
    }

    @Test
    void makeWelcomeText_시도_횟수_포함_검증() {
        // given
        int expectedTryCount = WordCondition.MAX_TRY_COUNT.value();

        // when
        String message = adapter.makeWelcomeText();

        // then
        assertTrue(message.contains(String.valueOf(expectedTryCount)),
                "환영 메시지에는 입력 제한 횟수가 포함되어야 합니다.");
    }

    @Test
    void makeBoardText_보드_리스트_포맷팅_검증() {
        // given
        List<String> boardList = List.of("🟩⬜⬜🟨⬜", "🟩🟩🟩🟩🟩");

        // when
        String result = adapter.makeBoardText(boardList);

        // then
        String expected = "🟩⬜⬜🟨⬜\n🟩🟩🟩🟩🟩\n";
        assertEquals(expected, result, "보드 리스트는 줄바꿈으로 구분되어 합쳐져야 합니다.");
    }

    @Test
    void makeBoardText_빈_보드일_경우_검증() {
        // given
        List<String> boardList = Collections.emptyList();

        // when
        String result = adapter.makeBoardText(boardList);

        // then
        assertEquals("", result, "입력이 없는 보드 리스트는 빈 문자열을 반환해야 합니다.");
    }
}
