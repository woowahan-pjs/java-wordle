import camp.nextstep.edu.missionutils.Console;
import com.wodle.GameHost;
import com.wodle.InputManager;
import com.wodle.ViewManager;
import com.wodle.WordsGenerator;
import com.wodle.domain.TileColor;

public class Application {

    public static void main(String[] args) {
        InputManager inputManager = new InputManager();
        ViewManager viewManager = new ViewManager();
        WordsGenerator wordsGenerator = new WordsGenerator();
        GameHost host = new GameHost(
            inputManager,
            viewManager,
            wordsGenerator
        );

        host.play();
    }

}
