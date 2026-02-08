import java.io.IOException;
import model.WordleGame;

public class Application {
    public static void main(String[] args) throws IOException {
        WordleGame game = new WordleGame();
        game.start();
    }
}
