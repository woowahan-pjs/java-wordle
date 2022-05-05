package domain;

import java.util.Map;

public class Answer {
    private final Letters todayAnswer;

    public Answer(Letters todayAnswer) {
        this.todayAnswer = todayAnswer;
    }

    public LetterResults compare(Letters userAnswer) {
        if (todayAnswer.equals(userAnswer)) {
            return LetterResults.correctAll();
        }

        LetterResults result = new LetterResults();
        Map<Letter, Long> countMap = todayAnswer.mapToCount();

        changeGreen(userAnswer, result, countMap);
        changeYellow(userAnswer, result, countMap);

        return result;
    }

    private void changeGreen(Letters userAnswer, LetterResults letterResults, Map<Letter, Long> countMap) {
        for (int i = 0; i < userAnswer.getSize(); i++) {
            Letter todayLetter = todayAnswer.getLetter(i);
            Letter userLetter = userAnswer.getLetter(i);

            if (todayLetter.equals(userLetter)) {
                letterResults.changeGreen(i);
                countMap.put(userLetter, countMap.get(userLetter) - 1);
            }
        }
    }

    private void changeYellow(Letters userAnswer, LetterResults letterResults, Map<Letter, Long> countMap) {
        for (int i = 0; i < userAnswer.getSize(); i++) {
            Letter userLetter = userAnswer.getLetter(i);
            if (countMap.getOrDefault(userLetter, 0L) > 0) {
                letterResults.changeYellow(i);
                countMap.put(userLetter, countMap.get(userLetter) - 1);
            }
        }
    }
}
