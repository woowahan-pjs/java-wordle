package woowaapplication.pair.game.wordle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import woowaapplication.pair.game.wordle.domain.Coin;
import woowaapplication.pair.game.wordle.domain.WordleBlock;

public class WordleGameStorage {

    private final List<WordleBlock[]> wordleBlocksHistory = new ArrayList<>();
    private final Coin coin;

    public WordleGameStorage(Coin coin) {
        this.coin = coin;
    }

    public int getRestChance() {
        return coin.getRestChance();
    }

    private boolean isGameOver() {
        return coin.isOutOfChance();
    }

    public boolean isGameClear() {
        if (wordleBlocksHistory.isEmpty()){
            return false;
        }
        return WordleBlock.isAllCorrect(wordleBlocksHistory.get(wordleBlocksHistory.size() - 1));
    }

    public boolean isGameEnd() {
        return isGameOver() || isGameClear();
    }

    public void submit(WordleBlock[] wordleBlocks) {
        wordleBlocksHistory.add(wordleBlocks);

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
