package wordle.view;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInput {

	private static final String ANSWER_REQUEST_MESSAGE = "정답을 입력해 주세요.";

	public static String readUserInput() {
		ConsoleOutput.printGameMessage(ANSWER_REQUEST_MESSAGE);
		return Console.readLine();
	}
}
