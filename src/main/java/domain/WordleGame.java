package domain;

public class WordleGame {

    private WordleComparer wordleComparer = new WordleComparer();

    public WordleGameStatus start(Wordles wordles, String inputWord) {
        // answer <-> inputWord 정답을 비교한다.
        wordles.add(inputWord);
        WordleGameStatus rseponse = wordleComparer.compareWordle(wordles, new Wordles(inputWord));

        return null;
    }
}
