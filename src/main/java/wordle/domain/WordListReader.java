package wordle.domain;

@FunctionalInterface
public interface WordListReader {
    WordList read();
}
