package wordle.domain;

public interface Word {
    boolean isSameAs(String word);

    String word();
}
