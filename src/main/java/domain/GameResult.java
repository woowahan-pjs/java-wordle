package domain;

import java.util.ArrayList;
import java.util.List;

public class GameResult {

    private final List<LetterResults> results = new ArrayList<>();

    public List<LetterResults> getResults() {
        return results;
    }

    public void addResult(LetterResults letterResults) {
        if (results.size() > 5) {
            throw new IllegalArgumentException("게임 결과는 6개까지 수용 가능합니다.");
        }
        results.add(letterResults);
    }

    public boolean isAllGreen() {
        return results.stream().filter(LetterResults::isAllGreen).count() == 1;
    }

    public boolean isMaxSize() {
        return results.size() == 6;
    }
}
