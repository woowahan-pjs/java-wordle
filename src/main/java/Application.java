import domain.Game;
import infra.LetterRepositoryImpl;

public class Application {
    public static void main(String[] args) {
        new Game(new LetterRepositoryImpl());
    }
}
