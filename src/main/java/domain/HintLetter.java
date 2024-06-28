package domain;

import java.util.List;
import java.util.Objects;

public class HintLetter {

    private final Character letter;
    private Hint hint;

    public HintLetter(Character letter, Hint hint) {
        this.letter = letter;
        this.hint = hint;
    }

    public boolean isCorrectHint() {
        return Hint.isCorrect(hint);
    }

    public void changeCorrectToNotExist(List<Character> correctedChar) {
        if(correctedChar.contains(letter) && !isCorrectHint()) {
            this.hint = Hint.NOT_EXIST;
        }
    }

    public String getHintTile() {
        return hint.getTile();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HintLetter that = (HintLetter) o;
        return Objects.equals(letter, that.letter) && hint == that.hint;
    }

    @Override
    public int hashCode() {
        return Objects.hash(letter, hint);
    }



}


