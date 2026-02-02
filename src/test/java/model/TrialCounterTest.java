package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrialCounterTest {
    TrialCounter trialCounter;

    @BeforeEach
    void setUp() {
        trialCounter = new TrialCounter();
    }

    @Test
    @DisplayName("increment 는 trials가 1 증가한다.")
    void increment() {
        TrialCounter trialCounter = new TrialCounter();

        trialCounter.increment();
        assertEquals(trialCounter.getTrials(), 1);

        trialCounter.increment();
        assertEquals(trialCounter.getTrials(), 2);
    }

    @Test
    @DisplayName("trials가 6회 미만이고 keepTrying 이면 true 를 반환한다.")
    void keepTryingIsTrue() {
        TrialCounter trialCounter = new TrialCounter();
        trialCounter.increment();
        trialCounter.increment();

        assertTrue(trialCounter.keepTrying());
    }

    @Test
    @DisplayName("trials가 6회를 초과하면 false 를 반환한다.")
    void keepTryingIsFalse() {
        TrialCounter trialCounter = new TrialCounter();
        for (int i = 0; i < 7; i++) {
            trialCounter.increment();
        }
        assertFalse(trialCounter.keepTrying());
    }
}