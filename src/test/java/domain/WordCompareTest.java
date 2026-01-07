package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WordCompareTest {

    @Test
    void 전부_일치인_경우() {
        Word answer = new Word("colon");
        Word inputWord = new Word("colon");
        MatchResult matchResults = answer.match(inputWord);

        assertThat(matchResults).containsExactly(
                Hint.CORRECT,
                Hint.CORRECT,
                Hint.CORRECT,
                Hint.CORRECT,
                Hint.CORRECT
        );
    }

    @Test
    void 일치인_문자가_중복인_경우() {
        Word answer = new Word("oozzz");
        Word inputWord = new Word("ooxxx");
        MatchResult matchResults = answer.match(inputWord);

        assertThat(matchResults).containsExactly(
                Hint.CORRECT,
                Hint.CORRECT,
                Hint.NOT_EXIST,
                Hint.NOT_EXIST,
                Hint.NOT_EXIST
        );
    }

    @Test
    void 존재하는_문자가_중복인_경우() {
        Word answer = new Word("zzzoo");
        Word inputWord = new Word("ooxxx");
        MatchResult matchResults = answer.match(inputWord);

        assertThat(matchResults).containsExactly(
                Hint.EXIST,
                Hint.EXIST,
                Hint.NOT_EXIST,
                Hint.NOT_EXIST,
                Hint.NOT_EXIST
        );
    }

    @Test
    void 전부_없는_경우() {
        Word answer = new Word("xxxxx");
        Word inputWord = new Word("ooooo");
        MatchResult matchResults = answer.match(inputWord);

        assertThat(matchResults).containsExactly(
                Hint.NOT_EXIST,
                Hint.NOT_EXIST,
                Hint.NOT_EXIST,
                Hint.NOT_EXIST,
                Hint.NOT_EXIST
        );
    }

    @Test
    void 전부_존재하는_경우() {
        Word answer = new Word("edbca");
        Word inputWord = new Word("abcde");
        MatchResult matchResults = answer.match(inputWord);

        assertThat(matchResults).containsExactly(
                Hint.EXIST,
                Hint.EXIST,
                Hint.EXIST,
                Hint.EXIST,
                Hint.EXIST
        );
    }

    @Test
    void 같은문자_두번_입력시_먼저_일치한_문자가_나오면_다른하나는_없다고_나와야한다() {
        Word answer = new Word("oxxxx");
        Word inputWord = new Word("oozzz");
        MatchResult matchResults = answer.match(inputWord);

        assertThat(matchResults).containsExactly(
                Hint.CORRECT,
                Hint.NOT_EXIST,
                Hint.NOT_EXIST,
                Hint.NOT_EXIST,
                Hint.NOT_EXIST
        );
    }

    // 와잼님이 짜준 테스트
    @Test
    void 같은문자_두번_입력시_하나가_존재하면_다른하나는_없다고_나와야한다() {
        Word answerWord = new Word("oxxxx"); // 정답
        Word inputWord = new Word("zoozz"); // input

        MatchResult results = answerWord.match(inputWord);

        assertThat(results).containsExactly(
                Hint.NOT_EXIST,
                Hint.EXIST,
                Hint.NOT_EXIST,
                Hint.NOT_EXIST,
                Hint.NOT_EXIST);
    }

    @Test
    void 같은문자_두번_입력시_하나가_먼저_일치하고_다음것이_존재하는경우() {
        Word answerWord = new Word("ooxxx");
        Word inputWord = new Word("ozozz");

        MatchResult results = answerWord.match(inputWord);

        assertThat(results).containsExactly(
                Hint.CORRECT,
                Hint.NOT_EXIST,
                Hint.EXIST,
                Hint.NOT_EXIST,
                Hint.NOT_EXIST
        );
    }
}
