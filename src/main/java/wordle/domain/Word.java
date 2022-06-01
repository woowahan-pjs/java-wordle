package wordle.domain;

import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static wordle.domain.BingoStatus.CONTAIN;
import static wordle.domain.BingoStatus.MATCH;
import static wordle.domain.BingoStatus.NOTHING;

public class Word {
    private static final int WORD_LENGTH = 5;
    private final String word;

    public Word(String word) {
        if (isNotValid(word)) {
            throw new IllegalArgumentException("유효하지 않은 단어 문자열 입니다.");
        }

        this.word = word;
    }

    private boolean isNotValid(String word) {
        return StringUtils.isBlank(word) || word.length() != WORD_LENGTH;
    }

    public List<BingoStatus> compare(Word otherWord) {
        final List<BingoStatus> resultBingoStatus = new ArrayList<>();

        for (int i = 0; i < WORD_LENGTH; i++) {
            final char otherChar = otherWord.word.charAt(i);
            final char myChar = word.charAt(i);

            bindingStatusByBingo(resultBingoStatus, myChar, otherChar);
        }

        return resultBingoStatus;
    }

    private void bindingStatusByBingo(List<BingoStatus> resultBingoStatus, char myChar, char otherChar) {
        if (isExactlyMatch(myChar, otherChar)) {
            resultBingoStatus.add(MATCH);
            return;
        }

        if (isContains(otherChar)) {
            resultBingoStatus.add(CONTAIN);
            return;
        }

        resultBingoStatus.add(NOTHING);
    }

    private Boolean isExactlyMatch(char myChar, char otherChar) {
        return myChar == otherChar;
    }

    private Boolean isContains(char otherChar) {
        return word.contains(String.valueOf(otherChar));
    }

    public String getWord() {
        return word;
    }

    @Override
    public String toString() {
        return word;
    }
}
