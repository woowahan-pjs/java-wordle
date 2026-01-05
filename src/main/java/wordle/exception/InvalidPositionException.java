package wordle.exception;

public class InvalidPositionException extends WordleInvalidInputException {

    public InvalidPositionException(String message) {
        super(message);
    }
}
