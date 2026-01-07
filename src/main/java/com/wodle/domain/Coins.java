package com.wodle.domain;

public class Coins {

    private int coin;

    public Coins(int availableCoin) {
        validate(availableCoin);

        this.coin = availableCoin;
    }

    public void use() {
        int tempCoin = this.coin - 1;
        validate(tempCoin);
        this.coin = tempCoin;
    }

    private void validate(int availableCoin) {
        if (availableCoin < 0) {
            throw new IllegalArgumentException("Coin can be set under 0");
        }
    }


    public boolean isEmpty() {
        return this.coin == 0;
    }
}
