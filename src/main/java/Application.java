import domain.WordleGame;

public class Application {

    public static void main(String[] args) {
        WordleGame wordleGame = new WordleGame();
        // 정답을 추출
        String answer = "answer";
        int count = 1;

        wordleGame.start(answer);

    }
}
