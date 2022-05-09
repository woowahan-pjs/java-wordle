package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Answer {

    private final Tiles tiles;

    public Answer(Tiles tiles) {
        this.tiles = tiles;
    }

    public MatchResult matches(Tiles tiles) {
        List<MatchStatus> matchStatusList = new ArrayList<>();

        for (Tile tile : tiles.getTiles()) {
            matchStatusList.add(matches(tile));

        }
        return new MatchResult(matchStatusList);
    }

    private MatchStatus matches(final Tile tile) {
        if (!tiles.contains(tile)) {
            return MatchStatus.GREY;
        }
        return hasGreen(tile)
                ? MatchStatus.GREEN
                : MatchStatus.YELLOW;
    }

    private boolean hasGreen(final Tile tile) {
        final List<MatchStatus> matchesList = new ArrayList<>();
        for (final Tile value : this.tiles.getTiles()) {
            matchesList.add(tile.matches(value));
        }

        return matchesList.contains(MatchStatus.GREEN);
    }


    @Override
    public String toString() {
        return "" + tiles.getTiles().stream()
                .map(Tile::getValue)
                .collect(Collectors.toList());
    }
}
