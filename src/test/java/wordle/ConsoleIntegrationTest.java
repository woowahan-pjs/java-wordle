package wordle;

import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.mockStatic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.time.Duration;
import java.time.LocalDate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.function.Executable;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public abstract class ConsoleIntegrationTest {

    private static final LocalDate ANSWER_DATE = LocalDate.parse("2021-06-22");
    public static final long TIME_LIMIT = 10L;
    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    protected final void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    protected final void printOutput() {
        System.setOut(standardOut);
        System.out.println(output());
    }

    protected final String output() {
        return captor.toString().trim();
    }

    protected final void run(final String... args) {
        assertTimeTest(() -> {
            try (MockedStatic<LocalDate> localDateMockedStatic = mockStatic(LocalDate.class,
                    Mockito.CALLS_REAL_METHODS)) {
                localDateMockedStatic.when(LocalDate::now).thenReturn(ANSWER_DATE);
                command(args);
                runMain();
            } catch (final Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void assertTimeTest(Executable executable) {
        assertTimeoutPreemptively(Duration.ofSeconds(TIME_LIMIT), executable);
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    protected abstract void runMain();
}
