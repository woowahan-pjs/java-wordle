import com.wodle.controller.GameHost;
import com.wodle.service.InputManager;
import com.wodle.service.InputMangerProxy;
import com.wodle.service.ViewManager;
import com.wodle.service.WordsGenerator;

public class Application {

    public static void main(String[] args) {
        ViewManager viewManager = new ViewManager();
        InputManager inputMangerProxy = new InputMangerProxy(viewManager);
        WordsGenerator wordsGenerator = new WordsGenerator();
        GameHost host = new GameHost(
            inputMangerProxy,
            viewManager,
            wordsGenerator
        );

        host.play();
    }

}
