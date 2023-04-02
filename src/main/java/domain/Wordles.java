package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Wordles {
    public static final int WORD_SIZE = 5;
    private final List<Wordle> answer;
    private final List<Wordle> input;

    public Wordles(String answer, String input) {
        this.answer = toWords(answer);
        this.input = toWords(input);
    }

    private List<Wordle> toWords(String word) {
        validateWord(word);
        
        List<Wordle> words = new ArrayList<>();

        for (char ch : word.toCharArray()) {
            words.add(new Wordle(ch));
        }

        return words;
    }

    private void validateWord(String word) {
        Objects.requireNonNull(word, "word must not null, word: " + word);

        if (word.length() != WORD_SIZE) {
            throw new IllegalArgumentException("word 단어의 길이는 5글자여야 합니다. 현재 길이: " + word.length());
        }

        if (!isAlpha(word)) {
            throw new IllegalArgumentException("word 단어는 영문자여야 합니다. 현재 단어: " + word);
        }

    }

    private boolean isAlpha(String s) {
        return s.matches("^[a-zA-Z]*$");
    }

    public List<TileColor> makeTileColorList() {
        List<TileColor> tileColors = new ArrayList<>();
        int size = answer.size();

        for (int i = 0; i < size; i++) {
            makeTileColor(tileColors, i);
        }
        return tileColors;
    }

    private List<TileColor> makeTileColor(List<TileColor> tileColors, int i) {
        if (isSameWordIndex(i)) {
            tileColors.add(TileColor.GREEN);
            return tileColors;
        }

        if (isSameWordDifferentIndex(i)) {
            tileColors.add(TileColor.YELLOW);
            return tileColors;
        }

        tileColors.add(TileColor.WHITE);
        return tileColors;
    }

    private boolean isSameWordIndex(int i) {
        return answer.get(i).getWord() == input.get(i).getWord();
    }

    private boolean isSameWordDifferentIndex(int i) {
        return answer.contains(input.get(i));
    }

}
