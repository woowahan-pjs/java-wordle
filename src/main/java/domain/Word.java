package domain;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Word {
    private final static int MAX_LENGTH = 5;
    private final String letters;

    protected Word(String value) {
        this.letters = value;
    }

    public static Word createAnswer(LocalDate currentDate, List<String> availableWords) {
        LocalDate fixedDate = LocalDate.of(2021, 6, 19);
        int diffDay = Period.between(fixedDate, currentDate).getDays();
        int index = diffDay % availableWords.size();

        return new Word(availableWords.get(index));
    }

    public static Word createInput(String value, List<String> availableWords) {
        validate(value, availableWords);
        return new Word(value);
    }

    public MatchResult match(Word otherWord) {
        boolean[] visited = new boolean[letters.length()];
        List<Hint> hints = IntStream.range(0, letters.length())
                .mapToObj(i -> matchLetter(otherWord, visited, i))
                .toList();

        return new MatchResult(hints);
    }

    private Hint matchLetter(Word otherWord, boolean[] visited, int index) {
        if(isCorrect(index, otherWord.letters.charAt(index))){
            visited[index] = true;
            return Hint.CORRECT;
        }

        char otherWordChar = otherWord.letters.charAt(index);
        if(this.exists(otherWordChar, visited)){
            visited[letters.indexOf(otherWordChar)] = true;
            return Hint.EXIST;
        }

        return Hint.NOT_EXIST;
    }

    private Boolean exists(char letter, boolean[] visited) {
        return IntStream.range(0, letters.length())
                .filter(i -> !visited[i] && letters.charAt(i) == letter)
                .findFirst()
                .isPresent();
    }

    private Boolean isCorrect(int index, char inputChar) {
        return letters.charAt(index) == inputChar;
    }

    private static void validate(String input, List<String> availableWords) {
        validateLength(input);

        validateOnlyEnglish(input);

        validateContain(input, availableWords);
    }

    private static void validateOnlyEnglish(String input) {
        if (!input.matches("^[a-zA-Z]+$")) {
            throw new IllegalArgumentException("영단어를 입력해주세요. [" + input + "]");
        }
    }

    private static void validateLength(String input) {
        if (input.length() != MAX_LENGTH) {
            throw new IllegalArgumentException(MAX_LENGTH + "자리의 단어를 입력해주세요.");
        }
    }

    private static void validateContain(String input, List<String> availableWords) {
        if (!availableWords.contains(input)) {
            throw new IllegalArgumentException("입력 불가능한 단어입니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word answer = (Word) o;

        return Objects.equals(letters, answer.letters);
    }

    @Override
    public int hashCode() {
        return letters != null ? letters.hashCode() : 0;
    }
}
