package wordle;


import wordle.game.base.Playable;
import wordle.game.wordle.WordleGame;

public class Application {

    public static void main(String[] args) {
        start(wordle());
    }

    private static void start(final Playable game) {
        game.play();
    }

    private static Playable wordle() {
        return new WordleGame("src/main/resources/words.txt");
    }

}
