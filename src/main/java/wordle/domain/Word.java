package wordle.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Word {
    private static final int MAX_LENGTH = 5;
    private final List<Letter> letters;

    public Word(String text) {
        validateLength(text);

        letters = new ArrayList<>();
        for (char ch : text.toCharArray()) {
            letters.add(new Letter(ch));
        }
    }

    public String castWordsToString() {
        StringBuilder wordsToString = new StringBuilder();

        for (Letter letter : letters) {
            wordsToString.append(letter.getValue());
        }

        return wordsToString.toString();
    }

    private void validateLength(String text) {
        if (text.length() != MAX_LENGTH) {
            throw new IllegalArgumentException("text length cannot be over than MAX_LENGTH");
        }
    }

    public List<Result> compare(Word target) {
        List<Result> results = new ArrayList<>();
        // 맞는 글자는 초록색, 위치가 틀리면 노란색, 없으면 회색
        for (int i = 0; i < letters.size(); i++) {
            Letter questionLetter = letters.get(i);
            Letter answerLetter = target.letters.get(i);

            if (answerLetter.equals(questionLetter)) {
                results.add(Result.CORRECT);
            } else if (letters.contains(answerLetter)) {
                results.add(Result.HALF_CORRECT);
            } else {
                results.add(Result.WRONG);
            }
        }
        return results;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return Objects.equals(letters, word.letters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(letters);
    }
}
