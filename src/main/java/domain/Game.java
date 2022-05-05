package domain;

public class Game {
    private final Words words;
    private final Answer answer;
    private final GameResult gameResult;
    private GameStatus gameStatus = GameStatus.PROGRESS;

    public Game(Words words) {
        this.answer = new Answer(words.getTodayWords());
        this.words = words;
        this.gameResult = new GameResult();
    }

    public GameResult getGameResult() {
        return gameResult;
    }

    public boolean isNotFinish() {
        return gameStatus == GameStatus.PROGRESS;
    }

    public GameStatus playGame(String word) {
        Letters letters = Letters.of(word);
        words.isContains(letters);
        LetterResults letterResults = answer.compare(letters);
        gameResult.addResult(letterResults);
        changeGameStatus();
        return gameStatus;
    }

    private void changeGameStatus() {
        if (gameResult.isAllGreen()) {
            gameStatus = GameStatus.WIN;
        }

        if (gameResult.isMaxSize()) {
            gameStatus = GameStatus.LOSE;
        }
    }

    public static Game start(Words words) {
        return new Game(words);
    }

}
