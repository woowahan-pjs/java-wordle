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

    public Letters(List<Letter> letters) {
        this.letters = letters;
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

    public boolean contains(Letter letter) {
        return letters.contains(letter);
    }

    public Letters findSameLetters(Letters other) {
        List<Letter> filteredLetters = this.letters.stream()
            .filter(other::contains)
            .toList();

        return new Letters(filteredLetters);
    }
}
