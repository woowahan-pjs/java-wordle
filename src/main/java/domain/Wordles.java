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
        // 정답과 사용자의 입력 비교
        int size = answer.size();
        for (int i = 0; i < size; i++) {
            if (answer.get(i).getWord() == input.get(i).getWord()) {
                tileColors.add(TileColor.GREEN);
            } else if (answer.contains(input.get(i))) {
                tileColors.add(TileColor.YELLOW);
            } else {
                tileColors.add(TileColor.WHITE);
            }

        }
        return tileColors;
    }

}
