package domain;

public class WordleGame {

    private WordleComparer wordleComparer = new WordleComparer();

    public WordleGameStatus start(Wordles wordles, String inputWord) {
        // answer <-> inputWord 정답을 비교한다.
        wordleComparer.compareWordle(wordles);

        // 5개의 Tile 생성, 1개의 Tiles 생성

        return null;
    }
}
