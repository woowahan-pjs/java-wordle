package woowaapplication.pair.game;

import woowaapplication.pair.game.wordle.WordleGame;

public class Application {

    public static void main(String[] args) {
        WordleGame wordleGame = new WordleGame();
        wordleGame.start();
    }
}
