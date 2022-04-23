package test.wordle.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WordsBucketTest {


    @Test
    void WordsBucket생성() {
        final WordsBucket wordsBucket = new WordsBucket("src/main/resources/words.txt");

        assertThat(wordsBucket.size()).isNotZero();
    }
}
