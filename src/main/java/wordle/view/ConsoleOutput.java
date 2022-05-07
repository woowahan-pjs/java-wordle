package wordle.view;

import wordle.model.GameAction;
import wordle.model.GameEndTurnAction;
import wordle.model.TileLine;
import wordle.model.TileStatus;
import wordle.model.Turn;
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
		Turn turn = endTurn.getTurn();
		Word answer = endTurn.getAnswer();

		if (turn.isCorrectedInTrying()) {
			System.out.format(TRYING_COUNT_MESSAGE_FORMAT, turn.getTryingCount());
		}

		for (TileLine tileLine : turn.getTileLines()) {
			printTileLine(tileLine);
		}

		if (turn.isOver()) {
			System.out.println();
			System.out.format(TODAY_ANSWER_MESSAGE, answer.getAnswerWordAsString());
		}
	}

	public static void printGameMessage(String gameMessage) {
		System.out.println(gameMessage);
	}

	private static void printTileLine(TileLine tileLine) {
		StringBuilder sb = new StringBuilder();

		TileStatus[] allStatus = tileLine.getAllStatus();
		for (TileStatus status : allStatus) {
			sb.append(status.toUnicode());
		}
		System.out.println(sb);
	}
}
