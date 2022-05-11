package wordle;


import wordle.app.game.base.Playable;
import wordle.config.WordleConfig;

public class Application {

    public static void main(final String[] args) {
        final Playable wordle = wordleConfig().wordle();
        wordle.play();
    }

    private static WordleConfig wordleConfig() {
        return new WordleConfig();
    }

}
