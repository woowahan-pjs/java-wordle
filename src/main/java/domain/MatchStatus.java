package domain;

public enum MatchStatus {
	GRAY("⬜"),
	YELLOW("\uD83D\uDFE8"),
	GREEN("\uD83D\uDFE9");

	private String unicode;

	MatchStatus(String unicode) {
		this.unicode = unicode;
	}

	@Override
	public String toString() {
		return unicode;
	}
}
