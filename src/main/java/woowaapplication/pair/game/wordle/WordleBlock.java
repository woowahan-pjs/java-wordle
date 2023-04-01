package woowaapplication.pair.game.wordle;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public enum WordleBlock {
    CORRECT("GREEN", "🟩"),
    EXIST_BUT_WRONG_SPOT("YELLOW", "🟨"),
    WRONG("GRAY", "⬜"),
    ;

    private final String color;
    private final String emoji;

    WordleBlock(String color, String emoji) {
        this.color = color;
        this.emoji = emoji;
    }

    public String getEmoji() {
        return emoji;
    }

    public static boolean isAllCorrect(WordleBlock[] wordleBlocks) {
        return Arrays.stream(wordleBlocks)
                .allMatch(block -> block == WordleBlock.CORRECT);
    }

    public static WordleBlock[] toList(String inputKeyword, String answerKeyword) {
        WordleBlock[] resultBlocks = new WordleBlock[WordleGame.KEYWORD_LENGTH];
        Set<Character> answerLetters = createAnswerLetters(answerKeyword);

        for (int index = 0; index < inputKeyword.length(); index++) {
            char inputLetter = inputKeyword.charAt(index);
            char answerLetter = answerKeyword.charAt(index);

            WordleBlock block = compareLetters(inputLetter, answerLetter, answerLetters);

            resultBlocks[index] = block;
        }

        return resultBlocks;
    }

    private static HashSet<Character> createAnswerLetters(String answerKeyword) {
        return answerKeyword.chars()
                .mapToObj(letter -> (char) letter)
                .collect(Collectors.toCollection(HashSet::new));
    }

    private static WordleBlock compareLetters(char inputLetter, char answerLetter, Set<Character> answerLetters) {
        if (answerLetter == inputLetter) {
            return WordleBlock.CORRECT;
        }

        if (answerLetters.contains(inputLetter)) {
            return WordleBlock.EXIST_BUT_WRONG_SPOT;
        }

        return WordleBlock.WRONG;
    }

    public static String[] toEmojiList(WordleBlock[] wordleBlocks) {
        return Arrays.stream(wordleBlocks)
                .map(WordleBlock::getEmoji)
                .toArray(String[]::new);
    }
}
