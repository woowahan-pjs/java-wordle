package wordle.model;

import java.util.List;

public class TileService {

    private static final String ANSWER_TILE = "\uD83D\uDFE9";

    private final TileStorage tileStorage;

    public TileService(TileStorage tileStorage) {
        this.tileStorage = tileStorage;
    }

    public Tiles create(Letters answerLetters, Letters inputLetters) {
        LetterCounter letterCounter = new LetterCounter(answerLetters);
        Tiles tiles = new Tiles(answerLetters.size());

        processSamePositionAndValueLetters(answerLetters, inputLetters, letterCounter, tiles);
        processSameValueLetters(answerLetters, inputLetters, letterCounter, tiles);
        processNoneMatchLetters(answerLetters, inputLetters, tiles);

        tileStorage.add(tiles);
        return tiles;
    }

    private void processSamePositionAndValueLetters(Letters answerLetters, Letters inputLetters, LetterCounter letterCounter, Tiles tiles) {
        Letters samePositionAndValueLetters = inputLetters.findSamePositionAndValueLetters(answerLetters);
        letterCounter.decreaseCount(samePositionAndValueLetters);
        tiles.addGreenTile(samePositionAndValueLetters);
    }

    private void processSameValueLetters(Letters answerLetters, Letters inputLetters, LetterCounter letterCounter, Tiles tiles) {
        Letters sameValueLetters = inputLetters.findSameValueLetters(answerLetters);
        Letters sameValueLettersForGrayTile = letterCounter.filterCanNotDecreaseCount(sameValueLetters);
        tiles.addGrayTile(sameValueLettersForGrayTile);

        Letters sameValueLettersForYellowTile = letterCounter.filterCanDecreaseCount(sameValueLetters);
        letterCounter.decreaseCount(sameValueLettersForYellowTile);
        tiles.addYellowTile(sameValueLettersForYellowTile);
    }

    private void processNoneMatchLetters(Letters answerLetters, Letters inputLetters, Tiles tiles) {
        Letters noneMatchingLetters = inputLetters.findNoneMatchingLetters(answerLetters);
        tiles.addGrayTile(noneMatchingLetters);
    }

    public boolean isAnswer(Tiles tiles) {
        return tiles.isFilledWith(ANSWER_TILE);
    }

    public List<Tiles> findAll() {
        return tileStorage.findAll();
    }
}
