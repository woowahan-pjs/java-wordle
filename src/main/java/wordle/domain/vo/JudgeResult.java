package wordle.domain.vo;

import java.util.Arrays;

public class JudgeResult {
    Color[] result;

    public JudgeResult(int size) {
        this.result = new Color[size];
    }

    public Color[] getResult() {
        return result;
    }

    public void setColor(int idx, Color color) {
        this.result[idx] = color;
    }

    private boolean isEndAble() {
        return Arrays.stream(result).allMatch(i -> i.equals(Color.GREEN));
    }

    public boolean continueGame() {
        return !isEndAble();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(result).forEach(it -> sb.append(it.getBox()));
        return sb.toString();
    }
}
