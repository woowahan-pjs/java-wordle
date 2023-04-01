package woowaapplication.pair.game.wordle;

public class Coin {

    private int restChance;

    public Coin(int restChance) {
        this.restChance = restChance;
    }

    public void decreaseChance() {
        if (restChance < 1) {
            // Exception
        }

        restChance -= 1;
    }

    public int getRestChance() {
        return restChance;
    }

    public boolean isGameOver() {
        return restChance < 1;
    }
}
