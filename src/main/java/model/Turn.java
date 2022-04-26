package model;

public class Turn {

    private static final int INIT_VALUE = 1;
    private static final int INCREASE_VALUE = 1;

    private int turn;

    public Turn() {
        this(INIT_VALUE);
    }

    public int increase() {
        return turn + INCREASE_VALUE;
    }
}
