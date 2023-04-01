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

        WordleGameStatus status;
        int count = 1;
        do {
            // 단어 입력
            String inputWord = "";
            status = wordleGame.start(answerWordles, inputWord);
            count++;
        } while(WordleGameStatus.END.equals(status) || count <= 6);

    }
}
