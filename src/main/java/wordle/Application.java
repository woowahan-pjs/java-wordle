package wordle;


import wordle.game.base.Game;
import wordle.game.wordle.WordleGame;

public class Application {

    public static void main(String[] args) {
        start(wordle());
    }

    private static void start(final Game game) {
        game.play();
    }

    private static Game wordle() {
        return new WordleGame("src/main/resources/words.txt");
    }

}
