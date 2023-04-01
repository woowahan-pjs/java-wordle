package domain;

import java.util.ArrayList;
import java.util.List;

public class Wordles {
    private final List<Wordle> answer;
    private final List<Wordle> input;

    public Wordles(String answer) {
        this.answer = toWords(answer);
    }

    private List<Wordle> toWords(String answer) {
        List<Wordle> words = new ArrayList<>();

        for (char ch : answer.toCharArray()) {
            words.add(new Wordle(ch));
        }

        return words;
    }


    public boolean compare(String inputWord) {

    }
}
