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


    public boolean isWordleCompleted() {
        // 정답과 사용자의 입력 비교
        int size = answer.size();
        for (int i = 0; i < size; i++) {
            if (isNotEqualWord(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean isNotEqualWord(int i) {
        return answer.get(i).getWord() != input.get(i).getWord();
    }
}
