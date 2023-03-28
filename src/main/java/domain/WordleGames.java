package domain;

public class WordleGames {

    private WordleGame wordleGame = new WordleGame();

    public void start(String answer) {
        //d
        //d
        // answer -> char
        Wordles wordles = new Wordles(answer);

        while (count <= 6) {
            // 단어 입력
            String inputWord = "";
            WordleGameResponse response = wordleGame.start(wordles, inputWord);
            if (response 정답이면) {
                break;
            }
            count++;
        }

    }
}
