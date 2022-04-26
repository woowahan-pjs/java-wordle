package model;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Result {

    MATCH (Result::isMatch)
    , EXIST(Result::isExist)
    , NON_EXIST(Result::isNonExist);

    private final BiPredicate<Character, Character> isMatch;

    Result(BiPredicate<Character, Character> isMatch) {
        this.isMatch = isMatch;
    }

    public BiPredicate<Character, Character> getIsMatch() {
        return isMatch;
    }

    private static boolean isMatch(Character value, Character answer) {
        return value.compareTo(answer) == 0 && value.getPosition() == answer.getPosition();
    }

    private static boolean isNonExist(Character value, Character answer) {
        return value.compareTo(answer) != 0;
    }

    private static boolean isExist(Character value, Character answer) {
        return value.compareTo(answer) == 0 && value.getPosition() != answer.getPosition();
    }

    public static Result valueOf(Character value, Character answer){
        return Arrays.stream(values())
                .filter(result -> result.getIsMatch().test(value,answer))
                .findAny()
                .orElse(NON_EXIST);
    }
}
