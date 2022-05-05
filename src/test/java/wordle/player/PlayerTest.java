package wordle.player;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import wordle.domain.Words;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    private Player player;
    private MockedStatic<Console> console;

    @BeforeEach
    void init() {
        player = new Player();
        console = Mockito.mockStatic(Console.class);
    }

    @AfterEach
    void destroy() {
        console.close();
    }

    @Test
    void 자동차들의이름을입력성공() {
        // given
        final String input = "apple";
        console.when(Console::readLine)
                .thenReturn(input);

        // when
        final Words result = player.inputWords();

        // then
        assertThat(result).isNotNull();
    }

}