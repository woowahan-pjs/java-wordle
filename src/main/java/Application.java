import java.time.LocalDate;

import controller.Game;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        game.start(LocalDate.now());
    }
}
