package wordle;

import wordle.model.*;
import wordle.view.Console;

public class Application {

    public static void main(String[] args) {
        Wordle wordle = new Wordle(new Console(), new WordService(new WordsReader()), new WordleValidator());
        wordle.start();
    }
}
