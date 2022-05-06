package wordle.view;

import wordle.model.GameAction;
import wordle.model.GameEndTurnAction;
import wordle.model.Grid;
import wordle.model.TileStatus;
import wordle.model.Tiles;
import wordle.model.Word;

public class ConsoleOutput {

	private static final String DIVIDER = "/";
	private static final String NEW_LINE = "\n";
	private static final int MAX_TRYING_COUNT = 6;
	private static final String GAME_START_MESSAGE_FORMAT =
		"WORDLE을 %d번 만에 맞춰 보세요." + NEW_LINE + "시도의 결과는 타일의 색 변화로 나타납니다." + NEW_LINE;
	private static final String TODAY_ANSWER_MESSAGE = "오늘의 정답 단어는 %s 입니다.";
	private static final String TRYING_COUNT_MESSAGE_FORMAT = NEW_LINE + "%d" + DIVIDER + MAX_TRYING_COUNT + NEW_LINE;

	public static void printGameAction(GameAction gameAction) {
		if (gameAction.isStart()) {
			printStartAction();
			return;
		}
		if (gameAction.isEndTurn()) {
			printEndTurnAction(gameAction);
			return;
		}
	}

	private static void printStartAction() {
		System.out.format(GAME_START_MESSAGE_FORMAT, MAX_TRYING_COUNT);
	}

	private static void printEndTurnAction(GameAction gameAction) {
		GameEndTurnAction endTurn = (GameEndTurnAction) gameAction;
		Grid grid = endTurn.getGrid();
		Word answer = endTurn.getAnswer();

//		// 정답이 입력되었을 때는 시도횟수 출력
		if (grid.isFinishedInTrying()) {
			System.out.format(TRYING_COUNT_MESSAGE_FORMAT, grid.getTryingCount());
		}

		for (Tiles tile : grid.getTilesList()) {
			printGameResult(tile);
		}
		System.out.println();

//		// 시도횟수가 다 되었을 때는 정답 출력
		if (grid.isOverTrying()) {
			System.out.format(TODAY_ANSWER_MESSAGE, answer.getAnswerWordAsString());
		}
	}

	public static void printGameException(String exceptionMessage) {
		System.out.println(exceptionMessage);
	}
	private static void printGameResult(Tiles tile) {
		for (TileStatus tileStatus : tile.getStatus()) {
			System.out.print(tileStatus.getUnicode());
		}
		System.out.println();
	}
}
