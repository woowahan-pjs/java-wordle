package wordle;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends ConsoleIntegrationTest {

    @Test
    void 게임_정상_진행_테스트() {
        run("hello", "12345" ,"label", "spell", "spill");
        assertThat(output()).containsIgnoringWhitespaces(
                """
                        ⬜⬜🟨🟩⬜
                        """,
                """
                        ⬜⬜🟨🟩⬜
                        🟨⬜⬜⬜🟩
                        """,
                """
                        ⬜⬜🟨🟩⬜
                        🟨⬜⬜⬜🟩
                        🟩🟩⬜🟩🟩
                        """,
                """
                        ⬜⬜🟨🟩⬜
                        🟨⬜⬜⬜🟩
                        🟩🟩⬜🟩🟩
                        🟩🟩🟩🟩🟩
                        """
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
