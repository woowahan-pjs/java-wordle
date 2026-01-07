package com.wodle.domain;


public class User {
    private final Coins coins;

    public User(int availableCoin) {
        this.coins = new Coins(availableCoin);
    }

    public boolean canPlay() {
        return !coins.isEmpty();
    }

    public void pay() {
        coins.use();
    }
}
