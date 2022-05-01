package wordle.view;

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
	private static final String INVALID_WORD_MESSAGE = "존재하지 않는 단어입니다.";
	private static final String TODAY_ANSWER_MESSAGE = "오늘의 정답 단어는 %s 입니다.";
	private static final String TRYING_COUNT_MESSAGE_FORMAT = NEW_LINE + "%d" + DIVIDER + MAX_TRYING_COUNT + NEW_LINE;
	private static final String INVALID_LENGTH_MESSAGE = "단어는 5글자로 구성되어야 합니다.";
	private static final String INVALID_ALPHABET_MESSAGE = "단어는 영문자로 구성되어야 합니다.";


	public void printGameStartMessage() {
		System.out.format(GAME_START_MESSAGE_FORMAT, MAX_TRYING_COUNT);
	}

	public void printGameResultMessage(Grid gameResult) {
		// 정답이 입력되었을 때는 시도횟수 출력
		if (gameResult.isFinishedInTrying()) {
			System.out.format(TRYING_COUNT_MESSAGE_FORMAT, gameResult.getTryingCount());
		}

		for (Tiles tile : gameResult.getTilesList()) {
			printGameResult(tile);
		}
		System.out.println();

		// 시도횟수가 다 되었을 때는 정답 출력
		if (gameResult.isOverTrying()) {
			Word answerWord = gameResult.getAnswerWord();
			System.out.format(TODAY_ANSWER_MESSAGE, answerWord.getAnswerWordAsString());
		}
	}

	public static void printInvalidLengthMessage() {
		System.out.println(INVALID_LENGTH_MESSAGE);
	}

	public static void printInvalidAlphabetMessage() {
		System.out.println(INVALID_ALPHABET_MESSAGE);
	}

	public static void printInvalidWordMessage() {
		System.out.println(INVALID_WORD_MESSAGE);
	}

	private void printGameResult(Tiles tile) {
		for (TileStatus tileStatus : tile.getStatus()) {
			System.out.print(tileStatus.getUnicode());
		}
		System.out.println();
	}
}
