package domain;

import java.util.List;

public class InputWord {
    private String values;
    private List<String> availableWords;

    public InputWord(String values, List<String> availableWords) {
        this.values = values;
        this.availableWords = availableWords;
        validate(values);
    }

    private void validate(String input) {
        if(this.availableWords.contains(input)){
            throw new IllegalArgumentException("입력 불가능한 단어입니다.");
        }
    }

}
