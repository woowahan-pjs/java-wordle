package dto;

import domain.Tile;

import java.util.List;
import java.util.stream.Collectors;

public class GameHistory {

    private final List<Tile> gameHistory;

    public GameHistory(List<Tile> gameHistory) {
        this.gameHistory = gameHistory;
    }

    public String getGameResult() {
        return gameHistory.stream().map(Tile::getTile)
                .collect(Collectors.joining());
    }
}
