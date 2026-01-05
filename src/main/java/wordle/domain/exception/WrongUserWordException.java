package wordle.domain.exception;

public class WrongUserWordException extends IllegalArgumentException {
    public WrongUserWordException(String message) {
        super(message);
    }
}
