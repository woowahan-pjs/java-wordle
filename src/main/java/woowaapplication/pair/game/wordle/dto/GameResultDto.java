package woowaapplication.pair.game.wordle.dto;

import java.util.List;
import java.util.stream.Collectors;

public class GameResultDto {
	private final String history;
	private final String chance;

	public GameResultDto(String history, String chance) {
		this.history = history;
		this.chance = chance;
	}

	public static GameResultDto of(List<String[]> scores, int totalChance, int restChance, boolean isGameEnd) {
		String chance = isGameEnd? (totalChance - restChance) + "/" + totalChance : null;

		String history = scores.stream()
				.map(array -> String.join(" ", array))
				.collect(Collectors.joining("\r"));

		return new GameResultDto(history, chance);
	}

	public String getHistory() {
		return history;
	}

	public String getChance() {
		return chance;
	}
}
