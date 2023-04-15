import com.wodle.controller.GameHost;
import com.wodle.service.InputManagerImpl;
import com.wodle.service.InputMangerProxy;
import com.wodle.service.ViewManagerImpl;
import com.wodle.service.WordGeneratorImpl;

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
