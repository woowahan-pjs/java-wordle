import model.Game;
import view.FileReader;

public class Application {

    private static final String FILE_NAME = "words.txt";

    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        String todayWord = fileReader.read(FILE_NAME);

        Game game = new Game(todayWord);
        game.play();
    }
}