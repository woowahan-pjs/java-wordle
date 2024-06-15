package wordle.domain;

import java.util.List;
import java.util.stream.IntStream;

public class Answer {
    private GameWord compositeWord;

    public Answer(GameWord word) {
        this.compositeWord = word;
    }

    public Answer(String word) {
        this(new GameWord(word));
    }

    public Alphabet find(final int index) {
        return compositeWord.find(index);
    }

    public Result examineResult(final Guess guess) {
        final List<ResultType> resultTypes = IntStream.range(0, guess.size())
                .mapToObj(i -> examineResultType(guess, i))
                .toList();

        return new Result(resultTypes);
    }

    private ResultType examineResultType(Guess guess, int index) {
        final Alphabet alphabet = guess.find(index);
        if (alphabet == this.find(index)) {
            return ResultType.MATCHED;
        }
        long answerCount = countAlphabets(alphabet, size());
        long guessCount = guess.countAlphabets(alphabet, index + 1);
        if (answerCount >= guessCount) {
            return ResultType.EXIST;
        }
        return ResultType.MISMATCHED;
    }

    private long countChar(GameWord word, Alphabet alphabet) {
        return word.alphabets().stream()
                .filter(alphabet::equals)
                .count();
    }

    public long countAlphabets(final Alphabet alphabet, final int endIndex) {
        return compositeWord.countAlphabets(alphabet, endIndex);
    }

    public int size() {
        return compositeWord.alphabets().size();
    }
}
