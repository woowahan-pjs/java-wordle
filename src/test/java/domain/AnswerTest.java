package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AnswerTest {
    @Test
    @DisplayName("정답은 매일 바뀌며 ((현재 날짜 - 2021년 6월 19일) % 배열의 크기) 번째의 단어이다")
    void answerSelectTest() {
        List<String> words = List.of("apple", "banana", "cherry", "date", "elderberry");
        Word answer = Word.createAnswer(LocalDate.of(2021, 6, 20), words);

        assertThat(answer).isEqualTo(new Word("banana"));
    }


    @Test
    @DisplayName("입력단어와 정답 비교")
    void matchTest() {
        List<String> words = List.of("apple", "banan", "cherr");

        Word inputWord = Word.createInput("cherr", words);
        Word answer = new Word("czzzh");
        MatchResult matchResults = answer.match(inputWord);

        MatchResult expected = new MatchResult(List.of(
                Hint.CORRECT,
                Hint.EXIST,
                Hint.NOT_EXIST,
                Hint.NOT_EXIST,
                Hint.NOT_EXIST
        ));
        assertThat(matchResults).isEqualTo(expected);
    }

    @Test
    @DisplayName("입력단어와 중복 단어 위치 확인 테스트")
    void matchLocationTest() {
        List<String> words = List.of("rxxrx");

        Word inputWord = Word.createInput("rxxrx", words);
        Word answer = new Word("cherr");
        MatchResult matchResults = answer.match(inputWord);

        MatchResult expected = new MatchResult(List.of(
                Hint.EXIST,
                Hint.NOT_EXIST,
                Hint.NOT_EXIST,
                Hint.CORRECT,
                Hint.NOT_EXIST
        ));
        assertThat(matchResults).isEqualTo(expected);
    }

    @Test
    @DisplayName("전부정답인 경우")
    void test() {
        List<String> words = List.of("colon");

        Word inputWord = Word.createInput("colon", words);
        Word answer = new Word("colon");
        MatchResult matchResults = answer.match(inputWord);

        MatchResult expected = new MatchResult(List.of(
                Hint.CORRECT,
                Hint.CORRECT,
                Hint.CORRECT,
                Hint.CORRECT,
                Hint.CORRECT
        ));
        assertThat(matchResults).isEqualTo(expected);
    }
}
