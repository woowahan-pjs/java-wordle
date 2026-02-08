package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TrialCounterTest {

    @Nested
    @DisplayName("increment 호출 시")
    class IncrementTest {
        @Test
        @DisplayName("한 번 호출하면 trials는 1이다")
        void incrementOnce() {
            //given
            final TrialCounter trialCounter = new TrialCounter(6);

            //when
            trialCounter.increment();

            //then
            assertThat(trialCounter.getTrials()).isEqualTo(1);
        }
    }

    @Nested
    @DisplayName("keepTrying 값은")
    class KeppTryingTests {
        @Test
        @DisplayName("trials가 6이면 keepTrying은 false다")
        void keepTryingIsFalseAtLimit() {
            //given
            TrialCounter counter = TrialCounter.withTrials(6);

            //when
            boolean result = counter.keepTrying();

            //then
            assertThat(result).isFalse();
        }

        @Test
        @DisplayName("trials가 5이면 keepTrying은 true다")
        void keepTryingIsTrueWhenTrialsUnderLimit() {
            //given
            TrialCounter counter = TrialCounter.withTrials(5);

            //when
            boolean result = counter.keepTrying();

            //then
            assertThat(result).isTrue();
        }

        @Test
        @DisplayName("trials가 6회를 초과하면 keepTrying은 false다")
        void keepTryingIsFalseWhenTrialsExceeded() {
            //given
            TrialCounter counter = TrialCounter.withTrials(7);

            //when
            boolean result = counter.keepTrying();

            //then
            assertThat(result).isFalse();
        }
    }

    @Nested
    @DisplayName("solveTheAnswer를 호출하면")
    class GameOverTests {
        @Test
        @DisplayName("trials가 남아있어도 keepTrying은 false다")
        void keepTryingIsFalseWhenSolvetheAnswer() {
            //given
            TrialCounter counter = TrialCounter.withTrials(0);
            counter.solveTheAnswer();

            //when
            boolean result = counter.keepTrying();

            //then
            assertThat(result).isFalse();
        }

        @Test
        @DisplayName("solved 값이 true가 된다")
        void solveTheAnswerSetsFlag() {
            //given
            TrialCounter counter = new TrialCounter(6);

            //when
            counter.solveTheAnswer();

            //then
            assertThat(counter.isSolved()).isTrue();
        }
    }

    @Nested
    @DisplayName("withTrials로 TrialCounter를 생성하면")
    class WithTrialsTests {
        @Test
        @DisplayName("trials가 설정된다")
        void withTrialsFactory() {
            //given & when
            TrialCounter counter = TrialCounter.withTrials(3);

            //then
            assertThat(counter.getTrials()).isEqualTo(3);
        }
    }
}
