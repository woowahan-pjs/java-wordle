package wordle;


import wordle.app.game.base.GameType;
import wordle.app.game.base.Playable;
import wordle.app.game.config.GameFactory;

public class Application {

    public static void main(final String[] args) {
        final Playable game = game(GameType.WORDLE);
        game.play();
    }

    private static Playable game(final GameType wordle) {
        return new GameFactory().gameConfig(wordle);
    }

}
