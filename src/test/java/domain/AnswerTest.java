package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AnswerTest {

    @Test
    void 알파벳5개가_모두일치() {
        String story = "story";
        Answer answer = new Answer(new Tiles(story));
        Tiles tiles = new Tiles(story);

        MatchResult matches = answer.matches(tiles);

        assertThat(matches.isCorrect()).isTrue();
    }

    @Test
    void 알파벳5개가_일치하지_않음() {
        Answer answer = new Answer(new Tiles("story"));
        Tiles tiles = new Tiles("solid");

        MatchResult matches = answer.matches(tiles);
        assertThat(matches.isCorrect()).isFalse();
    }
}
