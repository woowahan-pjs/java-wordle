import com.wodle.controller.GameHost;
import com.wodle.backend.InputManagerImpl;
import com.wodle.backend.InputMangerProxy;
import com.wodle.ui.ViewManagerImpl;
import com.wodle.backend.WordGeneratorImpl;

public class Application {

    public static void main(String[] args) {
        ViewManagerImpl viewManager = new ViewManagerImpl();
        InputManagerImpl inputMangerProxy = new InputMangerProxy(viewManager);
        WordGeneratorImpl wordGenerator = new WordGeneratorImpl();
        GameHost host = new GameHost(
            inputMangerProxy,
            viewManager,
            wordGenerator
        );

        host.play();
    }

}
