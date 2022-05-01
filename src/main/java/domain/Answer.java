package domain;

public class Answer {
    private final Letters TodayAnswer;
    public Answer(Letters todayAnswer) {
        this.TodayAnswer = todayAnswer;
    }

    public LetterResults compare(Letters userAnswer) {
        return new LetterResults();
    }
}
