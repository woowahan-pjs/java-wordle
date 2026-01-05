package wordle.vo;

public enum Color {
  GREEN("\uD83D\uDFE9"),
  YELLOW("\uD83D\uDFE8"),
  GRAY("\u2B1C");

  Color(String code) {
    this.code = code;
  }

  private final String code;

  public String getCode() {
    return code;
  }
}
