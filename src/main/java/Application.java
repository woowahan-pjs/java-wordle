import controller.WordleController;
import domain.WordleGames;

public class Application {

    public static void main(String[] args) {
        WordleController wordleController = new WordleController();
        wordleController.start();
    }
}
