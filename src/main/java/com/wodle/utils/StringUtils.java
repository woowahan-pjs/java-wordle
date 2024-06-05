package com.wodle.utils;

import java.util.regex.Pattern;

public class StringUtils {

    private static Pattern smallAlphabetLengthFivePattern = Pattern.compile(
        "[a-z]{5}");

    public static boolean matchesFiveSmallAlphabet(String input) {
        return smallAlphabetLengthFivePattern.matcher(input)
            .matches();
    }
}
