package wordle.domain.word;

import static org.junit.jupiter.api.Assertions.*;

import wordle.infrastructure.persistence.FileWordRepository;
import org.junit.jupiter.api.Test;

class AnswerSelectorTest {

    @Test
    void pickAnswer_유효한_단어_반환() {
        // given
        WordRepository wordRepository = new FileWordRepository();
        AnswerSelector answerSelector = new AnswerSelector(wordRepository);
        // when
        String answer = answerSelector.pickAnswer();
        // then
        assertNotNull(answer);
        assertEquals(5, answer.length()); // WordCondition.입력_제한_길이
        assertTrue(answer.matches("[a-z]+")); // 소문자 알파벳
    }

    @Test
    void pickAnswer_날짜_기반_일관성() {
        // given
        WordRepository wordRepository = new FileWordRepository();
        AnswerSelector answerSelector = new AnswerSelector(wordRepository);
        // when
        String answer1 = answerSelector.pickAnswer();
        String answer2 = answerSelector.pickAnswer();
        // then
        assertEquals(answer1, answer2); // 같은 날짜에 같은 결과
    }
}
