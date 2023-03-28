package domain;

import java.util.ArrayList;
import java.util.List;

public class Wordles {

    private final List<Wordle> words;

    public Wordles(String answer) {
        this.words = toWords(answer);
    }

    private List<Wordle> toWords(String answer) {
        List<Wordle> words = new ArrayList<>();

        for (char ch : answer.toCharArray()) {
            words.add(new Wordle(ch));
        }

        return words;
    }


}
