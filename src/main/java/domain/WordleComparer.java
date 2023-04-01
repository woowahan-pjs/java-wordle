package domain;

public class WordleComparer {

    public WordleGameStatus compareWordle(Wordles wordles) {
        if (wordles.isWordleCompleted()) {
            return WordleGameStatus.END;
        }

        return WordleGameStatus.ING;
    }
}
