package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LetterResultsTest {

    @Test
    @DisplayName("LetterResults의 초기값은 모두 Gray로 되어있다")
    void isAllGray() {
        LetterResults letterResults = new LetterResults();

        boolean actual = letterResults.getList().containsAll(
                List.of(LetterResult.GRAY, LetterResult.GRAY, LetterResult.GRAY, LetterResult.GRAY, LetterResult.GRAY)
        );

        assertThat(actual).isTrue();
    }

    @Test
    @DisplayName("LetterResults의 CorrectAll Method는 모두 Green으로 되어있다")
    void isAllGreen() {
        LetterResults letterResults = LetterResults.correctAll();

        boolean actual = letterResults.getList().containsAll(
                List.of(LetterResult.GREEN, LetterResult.GREEN, LetterResult.GREEN, LetterResult.GREEN, LetterResult.GREEN)
        );

        assertThat(actual).isTrue();
    }

    @Test
    @DisplayName("LetterResults의 상태를 YELLOW으로 바꾼다")
    void changeYellow() {
        LetterResults letterResults = new LetterResults();

        letterResults.changeYellow(0);

        assertThat(letterResults.getList().get(0)).isEqualTo(LetterResult.YELLOW);
    }

    @Test
    @DisplayName("LetterResults의 상태를 GREEN으로 바꾼다")
    void changeGreen() {
        LetterResults letterResults = new LetterResults();

        letterResults.changeGreen(0);

        assertThat(letterResults.getList().get(0)).isEqualTo(LetterResult.GREEN);
    }

    @Test
    @DisplayName("LetterResults가 모두 그린일 경우")
    void isCheckAllGreen() {
        LetterResults letterResults = new LetterResults();

        letterResults.changeGreen(0);
        letterResults.changeGreen(1);
        letterResults.changeGreen(2);
        letterResults.changeGreen(3);
        letterResults.changeGreen(4);

        assertThat(letterResults.isAllGreen()).isTrue();
    }

    @Test
    @DisplayName("LetterResults가 GREEN이 아닌 GRAY나 YELLOW가 포함 된 경우")
    void isCheckNotAllGreen() {
        LetterResults letterResults = new LetterResults();

        letterResults.changeGreen(0);
        letterResults.changeYellow(1);

        assertThat(letterResults.isAllGreen()).isFalse();
    }

}