package model;

import static model.Result.EXIST;
import static model.Result.MATCH;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ResultMatcherTest {

    @ParameterizedTest(name ="인풋 문자({1},{2})와 정답문자열{0}을 비교하면 {3}을 반환한다.")
    @CsvSource({"abbcc,a,0,MATCH","abbcc,a,2,EXIST","abbcc,e,0,NON_EXIST"})
    void match(String answer , String inputValue, int position, Result expected) {
        ResultMatcher matcher = new ResultMatcher();
        Characters ans = new Characters(answer);
        Character input = new Character(inputValue, position);

        Result result = matcher.match(input, ans);

        assertThat(result).isEqualTo(expected);
    }


    @DisplayName("결과를 매치 결과를 반환한다.")
    @Test
    void makeResults() {
        Characters ansWord = new Characters("abbcc");
        Characters inputWord = new Characters("abcbc");

        ResultMatcher matcher = new ResultMatcher();

        for (Character input : inputWord.convertToList()) {
            matcher.match(input,ansWord);
        }

        Results results = matcher.makeResults(ansWord);

        assertThat(results.convertToList()).containsExactly(MATCH,MATCH,EXIST,EXIST,MATCH);
    }
}