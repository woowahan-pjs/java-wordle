package wordle.domain;

import java.util.List;
import java.util.stream.IntStream;

public class Answer extends Word {

    public Answer(final Word select) {
        super(select.alphabets());
    }

    public Answer(String word) {
        super(word);
    }

    public Result examineResult(final Guess guess) {
        final List<ResultType> resultTypes = IntStream.range(0, guess.alphabets().size())
                .mapToObj(i -> examineResultType(guess, i))
                .toList();

        return new Result(resultTypes);
    }

    private ResultType examineResultType(Guess guess, int index) {
        final Alphabet alphabet = guess.find(index);
        if (alphabet == this.find(index)) {
            return ResultType.MATCHED;
        }
        long answerCount = countChar(this, alphabet);
        long guessCount = countChar(new Word(guess.subAlphabets(0, index + 1)), alphabet);
        if (answerCount >= guessCount) {
            return ResultType.EXIST;
        }
        return ResultType.MISMATCHED;
    }

    private long countChar(Word word, Alphabet alphabet) {
        return word.alphabets().stream()
                .filter(alphabet::equals)
                .count();
    }
}
