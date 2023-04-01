package domain;

public class WordleGame {

    public Tile start(Wordles wordles) {
        // answer <-> inputWord 정답을 비교한다.
        return new Tile(wordles.isWordleCompleted());

        // 5개의 Tile 생성, 1개의 Tiles 생성
    }
}
