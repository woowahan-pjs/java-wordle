package domain;

public class WordleGames {

    private WordleGame wordleGame = new WordleGame();

    public WordleGames() {

    }

    public void start(String answer) {
        //d
        //d
        // answer -> char
        Wordles answerWordles = new Wordles(answer);

        WordleGameResponse response;
        int count = 1;
        do {
            // 단어 입력
            String inputWord = "";
            response = wordleGame.start(answerWordles, inputWord);
            count++;
        } while(response.isNotEnd() || count <= 6);

    }
}
