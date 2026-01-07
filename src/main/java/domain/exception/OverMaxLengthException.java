package domain.exception;

public class OverMaxLengthException extends RuntimeException {
    public OverMaxLengthException(String message) {
        super(message);
    }
}
