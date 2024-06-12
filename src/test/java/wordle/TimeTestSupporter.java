package wordle;

import static org.mockito.Mockito.mockStatic;

import java.time.LocalDate;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class TimeTestSupporter {

    public static void runWithMock(final LocalDate mockDate, final Runnable runnable) {
        try (MockedStatic<LocalDate> localDateMockedStatic = mockStatic(LocalDate.class,
                Mockito.CALLS_REAL_METHODS)) {
            localDateMockedStatic.when(LocalDate::now).thenReturn(mockDate);
            runnable.run();
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
}
