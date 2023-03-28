import domain.WordleGames;

public class Application {

    public static void main(String[] args) {
        WordleGames wordleGames = new WordleGames();
        // 정답을 추출
        String answer = "answer";
        int count = 1;

        wordleGames.start(answer);

    }
}
