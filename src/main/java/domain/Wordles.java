package domain;

import java.util.ArrayList;
import java.util.List;

public class Wordles {
    private final List<Wordle> answer;
    private final List<Wordle> input;

    public Wordles(String answer, String input) {
        this.answer = toWords(answer);
        this.input = toWords(input);
    }

    private List<Wordle> toWords(String word) {
        // TODO: word 유효성 검증 추가
        List<Wordle> words = new ArrayList<>();

        for (char ch : word.toCharArray()) {
            words.add(new Wordle(ch));
        }

        return words;
    }

    public List<TileColor> isWordleCompleted() {
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
