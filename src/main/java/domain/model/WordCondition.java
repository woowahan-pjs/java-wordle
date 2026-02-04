
package domain.model;

public enum WordCondition {
    입력_제한_길이(5),
    입력_제한_횟수(6),
    ;

    private final int value;

    WordCondition(int value) {
        if (value < 0) {
            throw new IllegalArgumentException(
                name() + "는 음수가 될 수 없습니다. value=" + value
            );
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
