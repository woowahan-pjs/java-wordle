package domain;

import org.junit.jupiter.api.Test;

import javax.xml.stream.events.EndDocument;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WordleComparerTest {

    @Test
    void test() {
        Wordles answer = new Wordles("march");
        String inputWordle = "march";

        WordleComparer wordleComparer = new WordleComparer();
        WordleGameStatus wordleGameResponse = wordleComparer.compareWordle(answer, inputWordle);

        assertThat(wordleGameResponse).isEqualTo(WordleGameStatus.END);
    }

}
