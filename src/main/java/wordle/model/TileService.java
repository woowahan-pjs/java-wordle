package wordle.model;

import java.util.ArrayList;
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

    // TODO: 알고리즘에 오류가 있어 급한대로 정상 동작하게 변경하였음. 다시 잘 생각해보자.....
    private void processSameValueLetters(Letters answerLetters, Letters inputLetters, LetterCounter letterCounter, Tiles tiles) {
        Letters sameValueLetters = inputLetters.findSameValueLetters(answerLetters);

        List<Letter> lettersForYellowTile = new ArrayList<>();
        List<Letter> lettersForGrayTile = new ArrayList<>();
        for (Letter letter : sameValueLetters.getLetters()) {
            if (letterCounter.canDecreaseCount(letter)) {
                lettersForYellowTile.add(letter);
                letterCounter.decreaseCount(letter);
                continue;
            }

            lettersForGrayTile.add(letter);
        }

        tiles.addYellowTile(new Letters(lettersForYellowTile));
        tiles.addGrayTile(new Letters(lettersForGrayTile));
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
