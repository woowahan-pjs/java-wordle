import controller.Game;
import domain.AnswerGenerator;
import view.InputView;

import java.time.LocalDate;

public class WordleApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        AnswerGenerator answerGenerator = new AnswerGenerator("src/main/resources/words.txt");
        Game game = new Game(inputView, answerGenerator);
		game.start(LocalDate.now());
    }
}
