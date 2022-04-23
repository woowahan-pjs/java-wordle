package wordle.view;

public class ConsoleOutput {

	private static final String GAME_START_MESSAGE = "WORDLE을 6번 만에 맞춰 보세요.\n시도의 결과는 타일의 색 변화로 나타납니다.";

	public void printGameStartMessage() {
		System.out.println(GAME_START_MESSAGE);
	}

	public void printGameResultMessage(String gameResult) {
		System.out.println(gameResult);
	}
}
