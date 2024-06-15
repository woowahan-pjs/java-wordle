package wordle;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private final String input;
    private final List<Letter> inputLetters;

    public Input(String input) {
        this.input = input;
        inputLetters = new ArrayList<>();
        char[] inputArr = input.toCharArray();
        for (int i = 0; i < inputArr.length; i++) {
            inputLetters.add(new Letter(i, inputArr[i]));
        }
    }

    public boolean lessThan(int length) {
        return inputLetters.size() < length;
    }

    public String getValue() {
        return this.input;
    }
}
