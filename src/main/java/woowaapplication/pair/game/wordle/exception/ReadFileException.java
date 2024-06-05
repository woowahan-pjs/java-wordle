package woowaapplication.pair.game.wordle.exception;

public class ReadFileException extends RuntimeException {
    private static final String MESSAGE = "파일 데이터 읽기를 실패하였습니다.";

    public ReadFileException() {
        super(MESSAGE);
    }
}
