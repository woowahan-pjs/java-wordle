package wordle.domain.vo;

public enum Message {
    SUCCESS_END("축하합니다! 정답입니다!"),
    FAIL_END("실패했지만 축하드립니다!"),
    GAME_START("WORDLE을 6번 만에 맞춰 보세요.\n"
            + "시도의 결과는 타일의 색 변화로 나타납니다."),
    WRONG_INPUT("입력이 잘못되었습니다.\n"),
    GAME_END_INSTRUCTION("게임이 종료되었습니다"),
    USER_INPUT("정답을 입력해주세요.");

    public final String value;

    Message(String value) {
        this.value = value;
    }
}
