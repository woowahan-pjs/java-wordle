package domain;

import java.util.List;

public class InputWord {
    private String value;
    private List<String> availableWords;

    public InputWord(String value, List<String> availableWords) {
        this.value = value;
        this.availableWords = availableWords;
        validate(value);
    }

    private void validate(String input) {
        if(!this.availableWords.contains(input)){
            throw new IllegalArgumentException("입력 불가능한 단어입니다.");
        }
    }

}
