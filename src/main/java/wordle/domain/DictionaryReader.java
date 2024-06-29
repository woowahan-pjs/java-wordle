package wordle.domain;

@FunctionalInterface
public interface DictionaryReader {
    Dictionary read();
}
