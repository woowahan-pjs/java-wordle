package wordle.domain.game;

import wordle.domain.matching.MatchResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameResult {

    private final List<String> boardList = new ArrayList<>();

    public void addBoard(MatchResult[] resultArray) {
        StringBuilder rowStringBuilder = new StringBuilder();
        for (MatchResult resultValue : resultArray) {
            rowStringBuilder.append(resultValue.value());
        }
        this.boardList.add(rowStringBuilder.toString());
    }

    public String getLastBoard() {
        if (boardList.isEmpty()) {
            return "";
        }
        return boardList.getLast();
    }

    public int getTryCount() {
        return boardList.size() + 1;
    }

    public List<String> getBoardList() {
        return Collections.unmodifiableList(boardList);
    }
}
