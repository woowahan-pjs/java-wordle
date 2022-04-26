package model;

public class Turn {

    private static final int INIT_VALUE = 1;
    private static final int INCREASE_VALUE = 1;
    private static final int BOUNDARY_VALUE = 6;
    private static final String TURN_BOUNDARY_OVER_ERR_MSG = "6번까지 입력 가능합니다.";

    private int turn;

    public Turn() {
        this(INIT_VALUE);
    }

    Turn(int turn) {
        this.turn = turn;
    }

    public int increase() {
        validateIncrease();
        return turn += INCREASE_VALUE;
    }

    private void validateIncrease() {
        if (turn + INCREASE_VALUE > BOUNDARY_VALUE) {
            throw new IllegalStateException(TURN_BOUNDARY_OVER_ERR_MSG);
        }
    }

    public boolean isGameOver() {
        if(turn == BOUNDARY_VALUE) {
            return true;
        }

        return false;
    }
}
