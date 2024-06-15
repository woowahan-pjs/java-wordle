package wordle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Letters {

    private final List<Letter> letters;

    public Letters(String word) {
        char[] wordArr = word.toCharArray();

        this.letters = new ArrayList<>();
        for (int i = 0; i < wordArr.length; i++) {
            letters.add(new Letter(i, wordArr[i]));
        }
    }

    public List<Letter> getLetters() {
        return letters;
    }

    public boolean equalsPositionAndValue(Letter letter) {
        return letters.contains(letter);
    }

    public boolean lessThan(int size) {
        return letters.size() < size;
    }

    public String combine() {
        return letters.stream()
                .map(Letter::getValue)
                .collect(Collectors.joining(""));
    }
}
