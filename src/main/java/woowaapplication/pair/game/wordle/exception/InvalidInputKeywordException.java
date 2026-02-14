package woowaapplication.pair.game.wordle.exception;

public class InvalidInputKeywordException extends RuntimeException {

    private static final String MESSAGE = "입력한 키워드가 유효하지 않습니다.";

    public InvalidInputKeywordException() {
        super(MESSAGE);
    }
}
