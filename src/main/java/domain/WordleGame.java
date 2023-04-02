package domain;

public class WordleGame {

    public Tile start(Wordles wordles) {
        return new Tile(wordles.isWordleCompleted());
    }
}
