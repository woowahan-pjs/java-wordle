package wordle;

public class Main {

    public static void main(String[] args) {
        Wordle wordle = new Wordle(new Console(), new WordsReader(), new WordleValidator(), new TileService(new TileStorage()));
        wordle.start();
    }
}
