import controller.Wordle;
import view.InputView;
import view.ResultView;

public class Application {
    public static void main(String[] args) {
        new Wordle(new InputView(), new ResultView()).start();
    }
}
