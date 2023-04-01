package controller;

import domain.WordleGames;
import domain.Wordles;

public class WordleController {


    public void start() {
        // view 의 Input~  기능을 통해서 입력받고
        // view 의 Output~ 기능을 통해서 출력하고

        String answer = "answer";

        WordleGames wordleGames = new WordleGames();
        wordleGames.start(answer);

    }
}
