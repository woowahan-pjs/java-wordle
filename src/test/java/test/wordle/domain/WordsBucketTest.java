package test.wordle.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WordsBucketTest {


    @Test
    void WordsBucket생성(){
        WordsBucket wordsBucket = new WordsBucket();
        List<Words> words = wordsBucket.readWordsFile("src/main/resources/words.txt");

        assertThat(words).isNotEmpty();
    }
}
