package woowaapplication.pair.game.wordle;

import java.util.Arrays;

public enum WordleBlock {
    CORRECT("🟩"),
    EXIST_BUT_WRONG_SPOT("🟨"),
    WRONG("⬜"),
    ;

    private final String emoji;

    WordleBlock(String emoji) {
        this.emoji = emoji;
    }

    public String getEmoji() {
        return emoji;
    }

    public static String[] toEmojiList(WordleBlock[] wordleBlocks) {
        return Arrays.stream(wordleBlocks)
                .map(WordleBlock::getEmoji)
                .toArray(String[]::new);
    }
}
