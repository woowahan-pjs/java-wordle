package com.wodle.utils;

import java.util.regex.Pattern;

public class StringUtils {

    private static StringUtils stringUtils;

    private StringUtils() {
    }

    public static StringUtils getInstance() {
        if (stringUtils == null) {
            stringUtils = new StringUtils();
        }

        return stringUtils;
    }

    private static final Pattern smallAlphabetLengthFivePattern = Pattern.compile(
        "[a-z]{5}");

    public boolean matchesFiveSmallAlphabet(String input) {
        return smallAlphabetLengthFivePattern.matcher(input)
            .matches();
    }
}
