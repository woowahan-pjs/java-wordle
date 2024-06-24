package wordle.domain;

public record DictionaryWord(String word) implements Word {

    @Override
    public boolean isSameAs(final String other) {
        return word.equals(other);
    }
}
