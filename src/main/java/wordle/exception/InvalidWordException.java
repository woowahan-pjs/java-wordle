package wordle.exception;

public class InvalidWordException extends WordleInvalidInputException {

    public InvalidWordException(String message) {
        super(message);
    }
}
