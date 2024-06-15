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

    public Result examineResult(Guess guess) {
        List<ResultType> resultTypes = IntStream.range(0, guess.getWord().length())
                .mapToObj(i -> examineResultType(guess.getWord(), i))
                .toList();

        return new Result(resultTypes);
    }

    private ResultType examineResultType(String guess, int index) {
        char guessChar = guess.charAt(index);
        String answer = getWord();

        if (guessChar == answer.charAt(index))
            return ResultType.MATCHED;

        int answerCount = countChar(answer, guessChar);
        int guessCount = countChar(guess.substring(0, index + 1), guessChar);

        if (answerCount >= guessCount)
            return ResultType.EXIST;

        return ResultType.MISMATCHED;
    }

    private int countChar(String string, char ch) {
        return (int) string.chars().filter(c -> c == ch).count();
    }
}
