package view;

public class InputView {

	private static final String GAME_START_MESSAGE = "WORDLE을 6번 만에 맞춰보세요. \n시도의 결과는 타일의 색 변화로 나타납니다.";
	private static final String INPUT_GUIDE_MESSAGE = "정답을 입력해주세요.";

	public void printStartMessage() {
		System.out.println(GAME_START_MESSAGE);
	}

	public void printInputMessage() {
		System.out.println(INPUT_GUIDE_MESSAGE);
	}
}
