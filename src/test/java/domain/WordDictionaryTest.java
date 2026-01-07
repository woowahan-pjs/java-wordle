package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WordDictionaryTest {
    @Test
    @DisplayName("정답은 매일 바뀌며 ((현재 날짜 - 2021년 6월 19일) % 배열의 크기) 번째의 단어이다")
    void answerSelectTest() {
        List<String> words = List.of("apple", "spill", "naval");
        LocalDate now = LocalDate.of(2021, 6, 20);
        WordDictionary wordDictionary = new WordDictionary(words);

        assertThat(wordDictionary.answerWord(now)).isEqualTo(new Word("spill"));
    }
}
