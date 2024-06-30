package wordle.exception;

public class WordNotExistException extends WordleInvalidInputException {

    public WordNotExistException(String word) {
        super("올바르지 않은 단어입니다. (" + word + ")");
    }
}
