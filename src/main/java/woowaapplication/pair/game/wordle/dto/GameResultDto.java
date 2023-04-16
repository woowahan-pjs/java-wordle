package woowaapplication.pair.game.wordle.dto;

import java.util.List;
import java.util.stream.Collectors;

public class GameResultDto {
	private final String history;
	private final String chance;

	private final boolean isClear;

	public GameResultDto(String history, String chance, boolean isClear) {
		this.history = history;
		this.chance = chance;
		this.isClear = isClear;
	}

	public static GameResultDto of(List<String[]> scores, int totalChance, int restChance, boolean isClear) {
		String chance = isClear? (totalChance - restChance) + "/" + totalChance : null;

		String history = scores.stream()
				.map(array -> java.lang.String.join(" ", array))
				.collect(Collectors.joining("\n"));

		return new GameResultDto(history, chance, isClear);
	}

	public String getHistory() {
		return history;
	}

	public String getChance() {
		return chance;
	}

	public boolean isClear() {
		return isClear;
	}
}
