package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LetterRepositoryTest {
    @Test
    void test() {
        LetterRepository letterRepository = new LetterRepositoryImpl();
        assertThat(letterRepository.findAll()).hasSize(2309);
    }
}
