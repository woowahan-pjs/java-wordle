package domain.service;

import static org.junit.jupiter.api.Assertions.*;

import domain.port.WordRepository;
import domain.service.AnswerSelector;
import infrastructure.adapter.out.FileWordRepository;
import org.junit.jupiter.api.Test;

class AnswerSelectorTest {

    @Test
    void selectAnswer_유효한_단어_반환() {
        // given
        WordRepository wordRepository = new FileWordRepository();
        AnswerSelector answerSelector = new AnswerSelector(wordRepository);
        // when
        String answer = answerSelector.selectAnswer();
        // then
        assertNotNull(answer);
        assertEquals(5, answer.length()); // WordCondition.입력_제한_길이
        assertTrue(answer.matches("[a-z]+")); // 소문자 알파벳
    }

    @Test
    void selectAnswer_날짜_기반_일관성() {
        // given
        WordRepository wordRepository = new FileWordRepository();
        AnswerSelector answerSelector = new AnswerSelector(wordRepository);
        // when
        String answer1 = answerSelector.selectAnswer();
        String answer2 = answerSelector.selectAnswer();
        // then
        assertEquals(answer1, answer2); // 같은 날짜에 같은 결과
    }
}
