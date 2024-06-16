package domain;

import java.util.ArrayList;
import java.util.List;

public class InputWord {
    private final String value;
    private final static int MAX_LENGTH = 5;

    public MatchResults match(Answer answer){
        ArrayList<MatchResult> matchResults = new ArrayList<>();
        for(int i = 0; i< value.length(); i++){
            char c = value.charAt(i);
            if(answer.isCorrect(i, c)){
                matchResults.add(new MatchResult(c, Hint.CORRECT));
                continue;
            }
            if(answer.exists(c)){
                matchResults.add(new MatchResult(c, Hint.EXIST));
                continue;
            }
            matchResults.add(new MatchResult(c, Hint.NOT_EXIST));
        }
        return new MatchResults(matchResults);
    }

    public InputWord(String value, List<String> availableWords) {
        this.value = value;
        validate(value, availableWords);
    }

    private void validate(String input, List<String> availableWords) {
        validateLength(input);

        validateOnlyEnglish(input);

        validateContain(input, availableWords);
    }

    private void validateOnlyEnglish(String input) {
        if(!input.matches("^[a-zA-Z]+$")){
            throw new IllegalArgumentException("영단어를 입력해주세요. [{" + input + "}]");
        }
    }

    private void validateLength(String input) {
        if(input.length() != MAX_LENGTH){
            throw new IllegalArgumentException(MAX_LENGTH + "자리의 단어를 입력해주세요.");
        }
    }

    private void validateContain(String input, List<String> availableWords) {
        if(!availableWords.contains(input)){
            throw new IllegalArgumentException("입력 불가능한 단어입니다.");
        }
    }



}
