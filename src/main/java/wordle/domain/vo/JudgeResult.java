package wordle.domain.vo;

public class JudgeResult {
    Color[] result;

    public JudgeResult() {
        this.result = new Color[5];
    }

    public Color[] getResult() {
        return result;
    }

    public void setColor(int idx, Color color) {
        this.result[idx] = color;
    }

    public boolean isEndAble() {
        for (int i = 0; i < result.length; ++i) {
            if (!result[i].equals(Color.GREEN)) {
                return false;
            }
        }
        return true;
    }
}
