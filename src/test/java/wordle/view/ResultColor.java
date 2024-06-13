package wordle.view;

import wordle.domain.ResultType;

public enum ResultColor {
    GREEN(ResultType.MATCHED, "🟩"),
    YELLOW(ResultType.EXIST, "🟨"),
    WHITE(ResultType.MISMATCHED, "⬜");

    private ResultType resultType;
    private String color;

    ResultColor(ResultType resultType, String color) {
        this.resultType = resultType;
        this.color = color;
    }

    public static String color(ResultType resultType) {
        for (ResultColor resultColor : ResultColor.values()) {
            if (resultColor.resultType == resultType) {
                return resultColor.color;
            }
        }
        return WHITE.color;
    }
}
