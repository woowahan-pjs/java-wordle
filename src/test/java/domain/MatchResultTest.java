package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatchResultTest {

    @Test
    void equalsTest(){
        MatchResult matchResult1 = new MatchResult('a', Hint.CORRECT);
        MatchResult matchResult2 = new MatchResult('a', Hint.CORRECT);

        assertEquals(matchResult1, matchResult2);
    }
}
