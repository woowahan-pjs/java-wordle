package wordle.exception;

public class InvalidAlphabetException extends WordleInvalidInputException {

    public InvalidAlphabetException(String message) {
        super(message);
    }
}
