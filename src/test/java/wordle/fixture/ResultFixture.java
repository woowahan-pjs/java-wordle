package wordle.fixture;

import java.util.stream.IntStream;

import wordle.domain.*;

public class ResultFixture {

    public static Results createGreenResults(final int count) {
        final Results results = new Results();
        IntStream.range(0, count)
                .mapToObj(ResultFixture::createGreenResult)
                .forEach(results::add);
        return results;
    }

    public static Results createResults(final Tile tile, final Tile... tiles) {
        final Results results = new Results();
        results.add(new Result(tile, 0));
        IntStream.range(1, tiles.length + 1)
                .mapToObj(idx -> new Result(tiles[idx - 1], idx))
                .forEach(results::add);
        return results;
    }

    public static Result createGreenResult(final int position) {
        return new Result(Tile.GREEN, position);
    }

    public static ResultV2 createGreenResult(final Letter letter) {
        return new ResultV2(Tile.GREEN, letter);
    }

    public static Result createYellowResult(final int position) {
        return new Result(Tile.YELLOW, position);
    }

    public static ResultV2 createYellowResult(final Letter letter) {
        return new ResultV2(Tile.YELLOW, letter);
    }

    public static Result createGrayResult(final int position) {
        return new Result(Tile.GRAY, position);
    }

    public static ResultV2 createGrayResult(final Letter letter) {
        return new ResultV2(Tile.GRAY, letter);
    }
}
