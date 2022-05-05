package model;

import static model.Result.EXIST;
import static model.Result.MATCH;
import static model.Result.NON_EXIST;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultMatcher {

    private static final int RESULT_MIN_SIZE = 0;
    private static final int RESULT_MAX_SIZE = 5;
    private final Map<Character, Character> matchOfResult;

    public ResultMatcher() {
        matchOfResult = new HashMap<>();
    }

    public Result match(Character input, Characters answer) {
        Result result = NON_EXIST;
        for (Character ans : answer.convertToList()) {
            if (isMatch(input, ans)) {
                matchOfResult.put(ans, input);
                return MATCH;
            }
            if (isExist(input, ans)) {
                matchOfResult.put(ans, input);
                result = EXIST;
            }
        }
        return result;
    }

    private boolean isExist(Character input, Character ans) {
        return input.isSame(ans) == EXIST && !matchOfResult.containsKey(ans);
    }

    private boolean isMatch(Character input, Character ans) {
        return input.isSame(ans) == MATCH;
    }

    public Results makeResults(Characters answer) {
        List<Result> list = resultInit();

        for (Character ans : answer.convertToList()) {
            if (matchOfResult.containsKey(ans)) {
                Character input = matchOfResult.get(ans);
                list.set(input.getPosition(), input.isSame(ans));
            }
        }
        return new Results(list);
    }

    private List<Result> resultInit() {
        List<Result> list = new ArrayList<>();
        for (int i = RESULT_MIN_SIZE; i < RESULT_MAX_SIZE; i++) {
            list.add(NON_EXIST);
        }
        return list;
    }
}
