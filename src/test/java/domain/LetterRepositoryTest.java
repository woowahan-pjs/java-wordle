package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import stub.StubLetterRepository;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class LetterRepositoryTest {
    @DisplayName("오늘의 단어는 jason 입니다.")
    @Test
    void test() {
        String todayWord = "jason";
        LetterRepository letterRepository = new StubLetterRepository();
        assertThat(letterRepository.getTodayAnswer(LocalDate.now())).isEqualTo(Letters.of(todayWord));
    }
}
