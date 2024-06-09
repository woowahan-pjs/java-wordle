package wordle.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import wordle.exception.WordInputNotValidException;

public class Word {

    public static final int WORD_LENGTH = 5;
    private List<Letter> letters;

    public Word(String input) {
        if (input.length() != WORD_LENGTH) {
            throw new WordInputNotValidException();
        }

        this.letters = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            Letter letter = new Letter(input.charAt(i), i);
            this.letters.add(letter);
        }
    }

    public Results compare(Word targetWord) {
        Result[] results = new Result[WORD_LENGTH];
        for (int i = 0; i < WORD_LENGTH; i++) {
            Letter letter = letters.get(i);
            results[i] = targetWord.compare(letter);
        }
        return new Results(results);
    }

    private Result compare(Letter targetLetter){
        for (int i = 0; i < this.letters.size(); i++) {
            Letter letter = this.letters.get(i);
            if(letter.equals(targetLetter)){
                return new Result(Tile.GREEN, targetLetter.getPosition());
            }
        }

        for (int i = 0; i < this.letters.size(); i++) {
            Letter letter = this.letters.get(i);
            if(letter.isSameAlphabet(targetLetter)){
                return new Result(Tile.YELLOW, targetLetter.getPosition());
            }
        }

        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Word word = (Word) o;
        return Objects.equals(letters, word.letters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(letters);
    }
}
