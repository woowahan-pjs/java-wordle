package woowaapplication.pair.game.wordle;

import woowaapplication.pair.game.wordle.exception.OutOfChanceException;

public class Coin {

    private int restChance;

    public Coin(int restChance) {
        this.restChance = restChance;
    }

    public void decreaseChance() {
        if (restChance < 1) {
            throw new OutOfChanceException();
        }

        restChance -= 1;
    }

    public int getRestChance() {
        return restChance;
    }

    public boolean isOutOfChance() {
        return restChance < 1;
    }

    public static Coin of(int restChance) {
        return new Coin(restChance);
    }
}
