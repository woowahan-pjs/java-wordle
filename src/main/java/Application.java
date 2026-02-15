import controller.Game;

import java.time.LocalDate;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        game.start(LocalDate.now());
    }
}
