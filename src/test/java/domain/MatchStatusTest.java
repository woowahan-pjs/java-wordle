package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MatchStatusTest {

    @DisplayName("색상 출력 테스트")
    @Test
    void colorTest() {
        MatchStatus green = MatchStatus.GREEN;
        MatchStatus yellow = MatchStatus.YELLOW;
        MatchStatus gray = MatchStatus.GRAY;

        System.out.println("green = " + green);
        System.out.println("yellow = " + yellow);
        System.out.println("gray = " + gray);
    }

}
