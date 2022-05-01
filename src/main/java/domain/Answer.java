package domain;

import java.util.Arrays;
import java.util.List;

public class Answer {
    private final Letters todayAnswer;

    public Answer(Letters todayAnswer) {
        this.todayAnswer = todayAnswer;
    }

    public LetterResults compare(Letters userAnswer) {
        if (todayAnswer.equals(userAnswer)) {
            return LetterResults.correctAll();
        }
        List<Letter> todayAnswerList = todayAnswer.getList();
        List<Letter> userList = userAnswer.getList();
        List<LetterResult> letterResults = Arrays.asList(
                LetterResult.GRAY, LetterResult.GRAY, LetterResult.GRAY, LetterResult.GRAY, LetterResult.GRAY
        );
        for (int i = 0; i < userList.size(); i++) {
            if (todayAnswerList.get(i).equals(userList.get(i))) {
                letterResults.set(i, LetterResult.GREEN);
                todayAnswerList.set(i, null);
            }
        }
        
        for (int i = 0; i < userList.size(); i++) {
            if (letterResults.get(i) != LetterResult.GREEN) {
                for (int j = 0; j < todayAnswerList.size(); j++) {
                    if(userList.get(i).equals(todayAnswerList.get(j))) {
                        letterResults.set(i, LetterResult.YELLOW);
                        todayAnswerList.set(j, null);
                    }
                }
            }
        }



        return new LetterResults(letterResults);
    }
}
