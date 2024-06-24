package wordle.ui;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import wordle.domain.Record;
import wordle.domain.Tile;
import wordle.fixture.RecordFixture;
import wordle.fixture.ResultFixture;

class ConsoleOutputViewTest {

    private PrintStream standardOut;
    private OutputStream captor;

    private ConsoleOutputView consoleOutputView;

    @BeforeEach
    void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        consoleOutputView = new ConsoleOutputView();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    void printOutput() {
        System.setOut(standardOut);
    }

    @Test
    void Record를_출력할_수_있다() {
        Record record = createSuccessRecordFixture();

        consoleOutputView.showRecord(record);

        assertThat(captor.toString()).isEqualToNormalizingNewlines("""
                ⬜🟩⬜🟨⬜
                ⬜⬜⬜🟨⬜
                ⬜🟩🟨🟨⬜
                ⬜🟩⬜🟨⬜
                ⬜⬜⬜⬜⬜
                🟩🟩🟩🟩🟩
                
                """);
    }

    @Test
    void 게임_성공종료를_출력할_수_있다() {
        Record record = createSuccessRecordFixture();

        consoleOutputView.successEnd(record);

        assertThat(captor.toString()).isEqualToNormalizingNewlines("""
                
                6/6
                                
                ⬜🟩⬜🟨⬜
                ⬜⬜⬜🟨⬜
                ⬜🟩🟨🟨⬜
                ⬜🟩⬜🟨⬜
                ⬜⬜⬜⬜⬜
                🟩🟩🟩🟩🟩
                
                """);
    }
    @Test
    void 게임_실패종료를_출력할_수_있다() {
        Record record = createFailureRecordFixture();

        consoleOutputView.failEnd(record);

        assertThat(captor.toString()).isEqualToNormalizingNewlines("""
                
                X/6
                                
                ⬜⬜⬜⬜⬜
                ⬜⬜⬜⬜⬜
                ⬜⬜⬜🟨⬜
                ⬜⬜⬜🟨🟨
                ⬜⬜🟨🟨🟨
                🟩🟨🟨🟨🟨
                
                """);
    }

    private static Record createSuccessRecordFixture() {
        return RecordFixture.create(
                ResultFixture.createResults(Tile.GRAY, Tile.GREEN, Tile.GRAY, Tile.YELLOW,
                        Tile.GRAY),
                ResultFixture.createResults(Tile.GRAY, Tile.GRAY, Tile.GRAY, Tile.YELLOW,
                        Tile.GRAY),
                ResultFixture.createResults(Tile.GRAY, Tile.GREEN, Tile.YELLOW, Tile.YELLOW,
                        Tile.GRAY),
                ResultFixture.createResults(Tile.GRAY, Tile.GREEN, Tile.GRAY, Tile.YELLOW,
                        Tile.GRAY),
                ResultFixture.createResults(Tile.GRAY, Tile.GRAY, Tile.GRAY, Tile.GRAY, Tile.GRAY),
                ResultFixture.createResults(Tile.GREEN, Tile.GREEN, Tile.GREEN, Tile.GREEN,
                        Tile.GREEN)
        );
    }

    private static Record createFailureRecordFixture() {
        return RecordFixture.create(
                ResultFixture.createResults(Tile.GRAY, Tile.GRAY, Tile.GRAY, Tile.GRAY,
                        Tile.GRAY),
                ResultFixture.createResults(Tile.GRAY, Tile.GRAY, Tile.GRAY, Tile.GRAY,
                        Tile.GRAY),
                ResultFixture.createResults(Tile.GRAY, Tile.GRAY, Tile.GRAY, Tile.YELLOW,
                        Tile.GRAY),
                ResultFixture.createResults(Tile.GRAY, Tile.GRAY, Tile.GRAY, Tile.YELLOW,
                        Tile.YELLOW),
                ResultFixture.createResults(Tile.GRAY, Tile.GRAY, Tile.YELLOW, Tile.YELLOW, Tile.YELLOW),
                ResultFixture.createResults(Tile.GREEN, Tile.YELLOW, Tile.YELLOW, Tile.YELLOW,
                        Tile.YELLOW)
        );
    }
}
