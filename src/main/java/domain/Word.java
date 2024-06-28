package domain;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Stream;

public class Word {
    private final static int MAX_LENGTH = 5;
    private final String value;

    protected Word(String value) {
        this.value = value;
    }

    public static Word createAnswer(LocalDate currentDate, List<String> availableWords) {
        LocalDate fixedDate = LocalDate.of(2021, 6, 19);
        int diffDay = Period.between(fixedDate, currentDate).getDays();
        int index = diffDay % availableWords.size();

        return new Word(availableWords.get(index));
    }

    public static Word createInput(String value, List<String> availableWords) {
//        validate(value, availableWords);
        return new Word(value);
    }

    public MatchResult match(Word word) {
        List<Character> correctedChar = new ArrayList<>();

        List<HintLetter> hintLetters = getHintLetters(word, correctedChar);

        hintLetters.forEach(hintLetter -> hintLetter.changeCorrectToNotExist(correctedChar));

        return new MatchResult(hintLetters);
    }

    private List<HintLetter> getHintLetters(Word word, List<Character> correctedChar) {
        return Stream.iterate(0, i -> i + 1)
                .limit(value.length())
                .map(i -> getHintLetter(value, word, i, correctedChar))
                .toList();
    }


    private HintLetter getHintLetter(String value, Word word, Integer i, List<Character> correctedChar) {
        Hint hint = getHint(word, i);

        if (Hint.isCorrect(hint)) {
            correctedChar.add(word.getChar(i));
        }

        return new HintLetter(word.getChar(i), hint);
    }


    private Character getChar(int i) {
        return value.charAt(i);
    }

    private Hint getHint(Word word, int index) {
        char inputChar = word.getChar(index);

        if (isCorrect(index, inputChar)) {
            return Hint.CORRECT;
        }

        if (exists(inputChar)) {
            return Hint.EXIST;
        }
        return Hint.NOT_EXIST;
    }

    private Boolean exists(char inputChar) {
        return value.indexOf(inputChar) != -1;
    }

    private Boolean isCorrect(int index, char inputChar) {
        return value.charAt(index) == inputChar;
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

        return Objects.equals(value, answer.value);
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}
