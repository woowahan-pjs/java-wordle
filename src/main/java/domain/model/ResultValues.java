package domain.model;

public enum ResultValues {

    그린("🟩"),
    옐로우("🟨"),
    그레이("⬜"),
    ;

    private final String value;

    ResultValues(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static String correct() {
        return ResultValues.그린.getValue()
            .repeat(WordCondition.입력_제한_길이.getValue());
    }

    public static String inCorrect() {
        return ResultValues.그레이.getValue()
            .repeat(WordCondition.입력_제한_길이.getValue());
    }
}
