
package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AnswerTest {
    @Test
    @DisplayName("정답은 매일 바뀌며 ((현재 날짜 - 2021년 6월 19일) % 배열의 크기) 번째의 단어이다")
    void answerSelectTest(){
        List<String> words = List.of("apple", "banana", "cherry", "date", "elderberry");
        Answer answer = new Answer(LocalDate.of(2021, 6, 20), words);

        assertThat(answer).isEqualTo(new Answer("banana"));
    }
}
