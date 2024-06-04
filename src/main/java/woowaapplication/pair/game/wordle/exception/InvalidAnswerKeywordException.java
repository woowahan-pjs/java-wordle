package woowaapplication.pair.game.wordle.exception;

public class InvalidAnswerKeywordException extends RuntimeException {

    private static final String MESSAGE = "정답 키워드가 유효하지 않습니다.";

    public InvalidAnswerKeywordException() {
        super(MESSAGE);
    }
}
