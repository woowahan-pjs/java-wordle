package domain;

import java.util.ArrayList;
import java.util.List;

public class InputWord {
    private String value;
    private List<String> availableWords;

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
        this.availableWords = availableWords;
        validate(value);
    }

    private void validate(String input) {
        if(!this.availableWords.contains(input)){
            throw new IllegalArgumentException("입력 불가능한 단어입니다.");
        }
    }

}
