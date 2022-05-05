package domain;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
    private static final String MAXIMUM_GAME_RESULT = "게임 결과는 6개까지 수용 가능합니다.";
    private static final int MAXIMUM_RESULT_SIZE = 6;
    private static final int IS_CORRECT_ALL_GREEN_SIZE = 1;
    private final List<LetterResults> results = new ArrayList<>();

    public List<LetterResults> getResults() {
        return results;
    }

    public void addResult(LetterResults letterResults) {
        // letterResults가 들어올 때는 results에 추가가 되기 전이라서 1을 더해서 사이즈 체크를 한다.
        if (results.size() + 1 > MAXIMUM_RESULT_SIZE) {
            throw new IllegalArgumentException(MAXIMUM_GAME_RESULT);
        }
        results.add(letterResults);
    }

    public boolean isAllGreen() {
        return results.stream().filter(LetterResults::isAllGreen).count() == IS_CORRECT_ALL_GREEN_SIZE;
    }

    public boolean isMaxSize() {
        return results.size() == MAXIMUM_RESULT_SIZE;
    }
}
