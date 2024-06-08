package wordle.domain;

public class Guess extends Word {

    public Guess(String word) {
        super(word);
        validate(word);
    }

    private void validate(String word) {
        boolean result = word.chars()
                .mapToObj(c -> (char) c)
                .allMatch(c -> c >= 'a' && c <= 'z');

        if (!result) {
            throw new RuntimeException();
        }
    }
}
