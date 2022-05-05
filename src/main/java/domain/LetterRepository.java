package domain;

import java.util.List;

public interface LetterRepository {
    List<Letters> findAll();
}
