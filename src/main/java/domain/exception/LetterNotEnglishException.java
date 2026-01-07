package domain.exception;

public class LetterNotEnglishException extends RuntimeException {
    public LetterNotEnglishException(String message) {
        super(message);
    }
}
