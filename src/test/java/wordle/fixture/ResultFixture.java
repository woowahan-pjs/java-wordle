package wordle.fixture;

import wordle.domain.*;

import java.util.stream.IntStream;

public class ResultFixture {

    public static Results createGreenResults(final int count) {
        final Results results = new Results();
        IntStream.range(0, count)
                .mapToObj(i -> createGreenResult(new Letter('a', i)))
                .forEach(results::add);
        return results;
    }

    public static Results createResults(final Tile tile, final Tile... tiles) {
        final Results results = new Results();
        results.add(new Result(tile, new Letter('a', 0)));
        IntStream.range(1, tiles.length + 1)
                .mapToObj(idx -> new Result(tiles[idx - 1], new Letter('a', idx)))
                .forEach(results::add);
        return results;
    }

    public static Result createGreenResult(final Letter letter) {
        return new Result(Tile.GREEN, letter);
    }

    public static Result createYellowResult(final Letter letter) {
        return new Result(Tile.YELLOW, letter);
    }

    public static Result createGrayResult(final Letter letter) {
        return new Result(Tile.GRAY, letter);
    }
}
