package model;

public class Turn {

    private static final int INIT_VALUE = 0;
    private static final int INCREASE_VALUE = 1;
    private static final int BOUNDARY_VALUE = 6;
    private static final String TURN_BOUNDARY_OVER_ERR_MSG = "6번까지 입력 가능합니다.";

    private int value;

    public Turn() {
        this(INIT_VALUE);
    }

    Turn(int value) {
        this.value = value;
    }

    public int increase() {
        validateIncrease();
        return value += INCREASE_VALUE;
    }

    private void validateIncrease() {
        if (value + INCREASE_VALUE > BOUNDARY_VALUE) {
            throw new IllegalStateException(TURN_BOUNDARY_OVER_ERR_MSG);
        }
    }

    public boolean isGameOver() {
        return value == BOUNDARY_VALUE;
    }

    public int getValue() {
        return value;
    }
}
