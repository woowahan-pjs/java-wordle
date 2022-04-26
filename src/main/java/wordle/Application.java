package wordle;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        final WordleGameRunner wordleGameRunner = new WordleGameRunner();

        wordleGameRunner.run();
    }
}
