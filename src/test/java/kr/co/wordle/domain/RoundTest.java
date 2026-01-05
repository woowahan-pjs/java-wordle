package kr.co.wordle.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class RoundTest {

    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "asdf", "a", "133ke", "아ddsz", ""})
    void 입력값_유효하지_않음(String input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Round(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"cigar", "rebut", "sissy", "humph"})
    void 입력값_유효(String input) {
        Assertions.assertDoesNotThrow(() -> new Round(input));
    }

    @Test
    void 라운드_종료_여부_확인() {
        String input = "cigar";
        Round round = new Round(input);
        Assertions.assertFalse(round.isFinished());
    }

    @ParameterizedTest
    @CsvSource(value = {"cigar:cigar:GREEN", "stink:marry:GRAY", "marry:karma:YELLOW"}, delimiter = ':')
    void 정답과_비교(String input, String strAnswer, String tile) {
        Round round = new Round(input);
        Answer answer = new Answer(strAnswer);
        Tile expected = Tile.valueOf(tile);
        Tile result = round.getTile(answer.getCountPerCharacter(), answer.charAt(0), input.charAt(0));
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "cigar:cigar:🟩🟩🟩🟩🟩",
            "marry:karma:🟨🟩🟩⬜️⬜️",
            "major:marry:🟩🟩⬜️⬜️🟨",
            "hello:apple:⬜️🟨⬜️🟩⬜️",
            "happy:apple:⬜️🟨🟩🟨⬜️"
    }, delimiter = ':')
    void 라운드_결과_확인(String input, String answer, String expected) {
        Round round = new Round(input);
        String result = round.roundResult(new Answer(answer));
        Assertions.assertEquals(expected, result);
    }
}
