package domain;

import java.time.LocalDate;
import java.util.List;

public interface Bucket {
    Answer getAnswer(LocalDate today);
    boolean contains(Tiles tiles);

    List<Tiles> getTiles();
}
