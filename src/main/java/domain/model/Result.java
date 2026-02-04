package domain.model;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private StringBuilder board = new StringBuilder();
    private List<StringBuilder> boards = new ArrayList<>();

    public void addTile(String tile) {
        board.append(tile);
    }

    public void addBoard() {
        boards.add(board);
        board = new StringBuilder();
    }

    public String getBoard() {
        return board.toString();
    }

    public int getCurrentTryCount() {
        return boards.size() + 1;
    }

    public List<StringBuilder> getBoards() {
        return boards;
    }
}
