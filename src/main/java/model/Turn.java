package model;

public class Turn {

    private static final int INIT_VALUE = 0;
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

    public void increase() {
        if (isGameOver()) {
            throw new IllegalStateException(TURN_BOUNDARY_OVER_ERR_MSG);
        }
        turn += INCREASE_VALUE;
    }

    public boolean isGameOver() {
        return turn == BOUNDARY_VALUE;
    }

    public int getTurn() {
        return turn;
    }
}
