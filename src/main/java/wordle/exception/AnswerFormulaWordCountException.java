package wordle.exception;

public class AnswerFormulaWordCountException extends WordleException {

    public AnswerFormulaWordCountException() {
        super("계산을 위해서 단어는 1글자 이상이어야 합니다.");
    }
}
