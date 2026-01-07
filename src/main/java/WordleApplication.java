import config.FileConfig;
import controller.GameManager;
import infra.WordStringLoader;

import java.util.List;

public class WordleApplication {
    public static void main(String[] args) {
        List<String> wordStringList = WordStringLoader.readAll(FileConfig.FILE_PATH);
        GameManager gameManager = new GameManager(wordStringList);

        gameManager.start();
    }
}
