package wordle;

import wordle.application.WordleGame;
import wordle.domain.WordBook;
import wordle.ui.InputAndOutput;
import wordle.util.FileReader;

public class Application {

    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        WordBook wordBook = new WordBook(fileReader);

        InputAndOutput inputAndOutput = new InputAndOutput();

        WordleGame wordleGame = new WordleGame(wordBook, inputAndOutput);
        wordleGame.startGame();
    }
}
