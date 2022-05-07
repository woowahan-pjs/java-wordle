package stub;

import domain.LetterRepository;
import domain.Letters;

import java.time.LocalDate;

public class StubLetterRepository implements LetterRepository {
    @Override
    public Letters getTodayAnswer(LocalDate localDate) {
        return Letters.of("jason");
    }
}
