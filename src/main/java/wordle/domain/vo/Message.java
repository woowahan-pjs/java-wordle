package wordle.domain.vo;

public enum Message {
    SUCCESS_END("축하합니다! 정답입니다!");

    Message(String value) {
        this.value = value;
    }

    public final String value;
}
