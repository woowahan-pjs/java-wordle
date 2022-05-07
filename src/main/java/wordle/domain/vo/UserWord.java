package wordle.domain.vo;

public class UserWord {
    private String value;

    private UserWord(String value) {
        this.value = value;
    }

    public static UserWord of(String value) {
        validate(value);
        return new UserWord(value);
    }

    private static void validate(String value) throws IllegalArgumentException {
        if(value.length()!=5) {
            throw new IllegalArgumentException();
        }
    }

    public String getValue() {
        return value;
    }
}
