package wordle.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import wordle.fixture.ResultFixture;

public class RecordTest {

    @Test
    void Record에_초록색타일_5개_인_결과모음이_있으면_종료여부가_true이다() {
        Record record = createAllGreenRecord();

        assertThat(record.existAnswer()).isTrue();
    }

    @Test
    void Record가_결과모음이_6개이상이면_종료여부가_true이다() {
        Record record = createAllGrayRecord();

        assertThat(record.isCountOver()).isTrue();
    }

    private static Record createAllGreenRecord() {
        Record record = new Record();

        record.add(ResultFixture.createGreenResults(5));
        return record;
    }

    private static Record createAllGrayRecord() {
        Record record = new Record();

        for (int i = 0; i < Record.MAX_COUNT; i++) {
            record.add(ResultFixture.createResults(
                    Tile.GRAY,
                    Tile.GRAY,
                    Tile.GRAY,
                    Tile.GRAY,
                    Tile.GRAY)
            );
        }
        return record;
    }
}
