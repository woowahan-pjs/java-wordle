package wordle.vo;

public class UserWord {
    private String value;

    public UserWord(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) throws IllegalArgumentException {
        if(value.length()!=5) {
            throw new IllegalArgumentException();
        }
    }

    public String getValue() {
        return value;
    }
}
