package wordle;

import java.util.ArrayList;
import java.util.List;

public class GameMachine {
    public static List<Result> compare(String question, String answer) {
        String[] questionStrings = question.split("");

        String[] answerStrings = answer.split("");

        List<Result> results = new ArrayList<>();

        for (int i = 0; i < questionStrings.length; i++) {
            if (questionStrings[i].equals(answerStrings[i])) {
                results.add(Result.정답);
            } else if (answer.contains(questionStrings[i])) {
                results.add(Result.문자만_같음);
            } else {
                results.add(Result.틀림);
            }
        }

        return results;
    }
}
