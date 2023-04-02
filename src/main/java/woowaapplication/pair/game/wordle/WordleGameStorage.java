package woowaapplication.pair.game.wordle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WordleGameStorage {

    private final List<WordleBlock[]> wordleBlocksHistory = new ArrayList<>();
    private final Coin coin;
    private boolean isClear;

    public WordleGameStorage(Coin coin) {
        this.coin = coin;
        this.isClear = false;
    }

    public int getRestChance() {
        return coin.getRestChance();
    }

    public boolean isGameOver() {
        return coin.isOutOfChance();
    }

    public boolean isClear() {
        return isClear;
    }

    public void checkAnswer(WordleBlock[] wordleBlocks) {
        wordleBlocksHistory.add(wordleBlocks);
        isClear = WordleBlock.isAllCorrect(wordleBlocks);
    }

    public void decreaseChance() {
        if (isClear) {
            return;
        }

        coin.decreaseChance();
    }

    public List<String[]> convertHistoryToEmoji() {
        return wordleBlocksHistory.stream()
                .map(WordleBlock::toEmojiList)
                .collect(Collectors.toList());
    }

    public static WordleGameStorage of(Coin coin) {
        return new WordleGameStorage(coin);
    }
}
