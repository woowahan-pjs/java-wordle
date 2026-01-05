package wordle.fixture;

import java.util.stream.IntStream;
import wordle.domain.Result;
import wordle.domain.Results;
import wordle.domain.Tile;

public class ResultFixture {

    public static Results createGreenResults(int count) {
        Results results = new Results();
        IntStream.range(0, count)
                .mapToObj(ResultFixture::createGreenResult)
                .forEach(results::add);
        return results;
    }

    public static Results createResults(Tile tile, Tile... tiles) {
        Results results = new Results();
        results.add(new Result(tile, 0));
        IntStream.range(1, tiles.length + 1)
                .mapToObj(idx -> new Result(tiles[idx - 1], idx))
                .forEach(results::add);
        return results;
    }

    public static Result createGreenResult(int position) {
        return new Result(Tile.GREEN, position);
    }

    public static Result createYellowResult(int position) {
        return new Result(Tile.YELLOW, position);
    }

    public static Result createGrayResult(int position) {
        return new Result(Tile.GRAY, position);
    }
}
