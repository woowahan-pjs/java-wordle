package domain;

import java.util.Map;

public class Answer {
    private final Letters todayAnswer;

    public Answer(final Letters todayAnswer) {
        this.todayAnswer = todayAnswer;
    }

    public LetterResults compare(final Letters userAnswer) {
        if (todayAnswer.equals(userAnswer)) {
            return LetterResults.correctAll();
        }

        final LetterResults result = new LetterResults();
        final Map<Letter, Long> countMap = todayAnswer.mapToCount();

        changeGreen(userAnswer, result, countMap);
        changeYellow(userAnswer, result, countMap);

        return result;
    }

    private void changeGreen(final Letters userAnswer, final LetterResults letterResults, final Map<Letter, Long> countMap) {
        for (int i = 0; i < userAnswer.getSize(); i++) {
            final Letter todayLetter = todayAnswer.getLetter(i);
            final Letter userLetter = userAnswer.getLetter(i);

            if (todayLetter.equals(userLetter)) {
                letterResults.changeGreen(i);
                countMap.put(userLetter, countMap.get(userLetter) - 1);
            }
        }
    }

    private void changeYellow(final Letters userAnswer, final LetterResults letterResults, final Map<Letter, Long> countMap) {
        for (int i = 0; i < userAnswer.getSize(); i++) {
            final Letter userLetter = userAnswer.getLetter(i);
            if (countMap.getOrDefault(userLetter, 0L) > 0) {
                letterResults.changeYellow(i);
                countMap.put(userLetter, countMap.get(userLetter) - 1);
            }
        }
    }
}
