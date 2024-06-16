package wordle;

public class TileService {
    public Tiles create(Letters answerLetters, Letters inputLetters) {
        LetterCounter letterCounter = new LetterCounter(answerLetters);
        Tiles tiles = new Tiles(answerLetters.size());

        Letters samePositionAndValueLetters = inputLetters.findSamePositionAndValueLetters(answerLetters);
        letterCounter.decreaseCount(samePositionAndValueLetters);
        tiles.addGreenTile(samePositionAndValueLetters);

        Letters sameValueLetters = inputLetters.findSameValueLetters(answerLetters);
        Letters sameValueLettersForGrayTile = letterCounter.filterCanNotDecreaseCount(sameValueLetters);
        tiles.addGrayTile(sameValueLettersForGrayTile);

        Letters sameValueLettersForYellowTile = letterCounter.filterCanDecreaseCount(sameValueLetters);
        letterCounter.decreaseCount(sameValueLettersForYellowTile);
        tiles.addYellowTile(sameValueLettersForYellowTile);

        Letters noneMatchingLetters = inputLetters.findNoneMatchingLetters(answerLetters);
        tiles.addGrayTile(noneMatchingLetters);

        return tiles;
    }
}
