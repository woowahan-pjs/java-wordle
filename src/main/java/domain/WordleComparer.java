package domain;

public class WordleComparer {

    public WordleGameStatus compareWordle(Wordles wordles, Wordles inputWord) {
        if (wordles.compare(inputWord)) {
            return WordleGameStatus.END;
        }

        return WordleGameStatus.ING;
    }
}
