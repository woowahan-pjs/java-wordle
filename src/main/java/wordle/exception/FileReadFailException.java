package wordle.exception;

public class FileReadFailException extends RuntimeException{

    public FileReadFailException(final String message) {
        super(message);
    }

    public FileReadFailException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
