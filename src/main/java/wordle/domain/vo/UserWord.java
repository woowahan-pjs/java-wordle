package wordle.domain.vo;

import wordle.domain.exception.WrongUserWordException;

public class UserWord {
    private String value;

    private UserWord(String value) {
        this.value = value;
    }

    public static UserWord of(String value) {
        validate(value);
        return new UserWord(value);
    }

    private static void validate(String value) throws WrongUserWordException {
        if (value.length() != 5) {
            throw new WrongUserWordException("문자열의 길이가 잘못되었습니다!");
        }
    }

    public String getValue() {
        return value;
    }
}
