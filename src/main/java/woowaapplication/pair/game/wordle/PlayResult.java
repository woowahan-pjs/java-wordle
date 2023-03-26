package woowaapplication.pair.game.wordle;

public class PlayResult {
    private final WordleBlock[] wordleBlocks;
    private final Coin coin;

    public PlayResult(WordleBlock[] wordleBlocks, Coin coin) {
        this.wordleBlocks = wordleBlocks;
        this.coin = coin;
    }

    public WordleBlock[] getWordleBlocks() {
        return wordleBlocks;
    }

    public Coin getCoin() {
        return coin;
    }
}
