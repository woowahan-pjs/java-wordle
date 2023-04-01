package domain;

import java.util.List;

public class WordleComparer {

    public Tiles compareWordle(Wordles wordles) {
        List<TileColor> wordleCompleted = wordles.isWordleCompleted();
        return new Tiles();
    }
}
