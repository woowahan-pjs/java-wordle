import controller.GameManager;
import infra.WordLoader;

public class WordleApplication {
    public static void main(String[] args) {
        String filePath = "src/main/resources/english_words_10k_mit.txt";
        GameManager gameManager = new GameManager(WordLoader.read(filePath));
        gameManager.startGame();
    }

}
