package test.wordle.domain;

public class Answer {

    private final Words words;

    public Answer(final Words words) {
        this.words = words;
    }

    public boolean matches(final Words words) {
        return this.words.equals(words);
    }
}
