package model;

import static model.Result.EXIST;
import static model.Result.MATCH;
import static model.Result.NON_EXIST;

public class Character implements Comparable<Character> {

    public static final String ILLEGAL_INPUT_ERR_MSG = "영어만 입력이 가능합니다.";
    private static final String INPUT_RANGE = "[a-zA-Z]";

    private static final int POSITION_INIT = 0;
    private static final int MATCH_VALUE = 0;

    private final int position;
    private final String value;

    public Character(String value) {
        this(value, POSITION_INIT);
    }

    public Character(String value, int position) {
        validate(value);
        this.value = convertToLowercase(value);
        this.position = position;
    }

    private void validate(String value) {
        if (!value.matches(INPUT_RANGE)) {
            throw new IllegalArgumentException(ILLEGAL_INPUT_ERR_MSG);
        }
    }

    @Override
    public int compareTo(Character other) {
        return value.compareTo(other.value);
    }

    private String convertToLowercase(String value) {
        return value.toLowerCase();
    }

    public int getPosition() {
        return this.position;
    }

    public Result isSame(Character answer) {
        if (isMatchValue(answer) && isMatchPosition(answer)) {
            return MATCH;
        }

        if (isMatchValue(answer) && !isMatchPosition(answer)) {
            return EXIST;
        }

        return NON_EXIST;
    }

    private boolean isMatchPosition(Character answer) {
        return position == answer.getPosition();
    }

    private boolean isMatchValue(Character answer) {
        return value.compareTo(answer.value) == MATCH_VALUE;
    }
}
