package wordle.domain;

import java.util.List;
import java.util.stream.IntStream;

public class Answer {
    private static final int START_INDEX = 0;
    private static final int EXCLUDE_UNIT = 1;

    private final Word word;

    public Answer(final Word word) {
        this.word = word;
    }

    public Answer(final String word) {
        this(new Word(word));
    }

    public Alphabet find(final int index) {
        return word.find(index);
    }

    public Result examineResult(final Guess guess) {
        final List<ResultType> resultTypes = IntStream.range(START_INDEX, guess.size())
                .mapToObj(i -> examineResultType(guess, i))
                .toList();
        return new Result(resultTypes);
    }

    private ResultType examineResultType(final Guess guess, final int index) {
        final Alphabet alphabet = guess.find(index);
        if (alphabet == this.find(index)) {
            return ResultType.MATCHED;
        }
        long answerCount = countAlphabets(alphabet, size());
        long guessCount = guess.countAlphabets(alphabet, index + EXCLUDE_UNIT);
        if (answerCount >= guessCount) {
            return ResultType.EXIST;
        }
        return ResultType.MISMATCHED;
    }

    public long countAlphabets(final Alphabet alphabet, final int endIndex) {
        return word.countAlphabets(alphabet, endIndex);
    }

    public int size() {
        return word.size();
    }
}
