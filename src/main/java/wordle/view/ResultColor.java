package wordle.view;

import wordle.domain.ResultType;

import java.util.Arrays;

public enum ResultColor {
    GREEN(ResultType.MATCHED, "🟩"),
    YELLOW(ResultType.EXIST, "🟨"),
    WHITE(ResultType.MISMATCHED, "⬜");

    private final ResultType resultType;
    private final String color;

    ResultColor(final ResultType resultType, final String color) {
        this.resultType = resultType;
        this.color = color;
    }

    public static String color(final ResultType resultType) {
        return Arrays.stream(ResultColor.values())
                .filter(it -> resultType.equals(it.resultType))
                .map(it -> it.color)
                .findFirst()
                .orElse(WHITE.color);
    }
}
