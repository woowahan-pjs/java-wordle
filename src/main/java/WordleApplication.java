import config.FileConfig;
import controller.GameManager;
import infra.WordLoader;

import java.util.List;

public class WordleApplication {
    public static void main(String[] args) {

        List<String> words = WordLoader.read(FileConfig.FILE_PATH);
        GameManager gameManager = new GameManager(words);

        gameManager.start();

    }

}
