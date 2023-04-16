package woowaapplication.pair.game.wordle.exception;

public class OutOfChanceException extends RuntimeException {

    private static final String MESSAGE = "남은 기회가 없습니다.";

    public OutOfChanceException() {
        super(MESSAGE);
    }
}
