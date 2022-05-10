import domain.Game;
import infra.LetterRepositoryImpl;

public class Application {
    public static void main(String[] args) {
        Game game = new Game(new LetterRepositoryImpl());
        game.start();
    }
}
