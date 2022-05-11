package util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import model.Characters;
import org.junit.jupiter.api.Test;

class AnswerGroupProviderTest {

    @Test
    void provide() {
        List<Characters> provide = AnswerGroupProvider.provide();

        assertThat(provide.size()).isEqualTo(2309);
    }
}