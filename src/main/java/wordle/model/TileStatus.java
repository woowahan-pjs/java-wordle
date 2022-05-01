package wordle.model;

public enum TileStatus {

	GREEN("\uD83D\uDFE9"), YELLOW("\uD83D\uDFE8"), GRAY("⬜");

	private final String unicode;

	TileStatus(String unicode) {
		this.unicode = unicode;
	}

	public String getUnicode() {
		return this.unicode;
	}
}
