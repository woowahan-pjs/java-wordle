import com.wodle.controller.GameHost;
import com.wodle.service.InputManager;
import com.wodle.service.InputViewManager;
import com.wodle.service.ViewManager;
import com.wodle.service.WordsGenerator;

public class Application {

    public static void main(String[] args) {
        ViewManager viewManager = new ViewManager();
        InputManager inputManager = new InputViewManager(viewManager);
        WordsGenerator wordsGenerator = new WordsGenerator();
        GameHost host = new GameHost(
            inputManager,
            viewManager,
            wordsGenerator
        );

        host.play();
    }

}
