package woowaapplication.pair.game.wordle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WordleGameStorage {

    private final List<WordleBlock[]> wordleBlocksHistory = new ArrayList<>();
    private final Coin coin;
    private boolean isClear;

    private WordleGameStorage(Coin coin) {
        this.coin = coin;
        this.isClear = false;
    }

    public static WordleGameStorage of(Coin coin) {
        return new WordleGameStorage(coin);
    }

    public int getRestChance() {
        return coin.getRestChance();
    }

    public boolean isOutOfChance() {
        return coin.isOutOfChance();
    }

    public boolean isClear() {
        return isClear;
    }

    public void checkAnswer(String inputKeyword, AnswerKeyword answerKeyword) {
        isClear = answerKeyword.isCorrect(inputKeyword);
        wordleBlocksHistory.add(answerKeyword.convertToWordleBlocks(inputKeyword));
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
}
