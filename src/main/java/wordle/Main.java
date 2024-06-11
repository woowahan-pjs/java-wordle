package wordle;

public class Main {

    public static void main(String[] args) {
        Wordle wordle = new Wordle(new IOView(), new WordsReader());
        wordle.start();
    }
}
