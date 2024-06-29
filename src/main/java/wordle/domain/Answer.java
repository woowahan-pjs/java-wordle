package wordle.domain;


import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Answer {
    private static final int START_INDEX = 0;
    private static final long DEFAULT_COUNT = 0L;
    private static final long DECREASE_COUNT_UNIT = 1L;

    private final GameWord word;

    public Answer(final GameWord word) {
        this.word = word;
    }

    public Answer(final String word) {
        this(new GameWord(word));
    }

    public Alphabet find(final int index) {
        return word.find(index);
    }

    public Result examine(final Guess guess) {
        final List<ResultType> matchedResults = IntStream.range(START_INDEX, word.size())
                .mapToObj(index -> {
                    final Alphabet answerAlphabet = find(index);
                    final Alphabet guessAlphabet = guess.find(index);
                    if (answerAlphabet.equals(guessAlphabet)) {
                        return ResultType.MATCHED;
                    }
                    return ResultType.NONE;
                })
                .toList();

        final Map<Alphabet, Long> unmatchedAnswerCounts = IntStream.range(START_INDEX, word.size())
                .filter(index -> ResultType.NONE.equals(matchedResults.get(index)))
                .mapToObj(this::find)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        final List<ResultType> resultTypes = IntStream.range(START_INDEX, matchedResults.size())
                .mapToObj(index -> {
                    if (ResultType.MATCHED.equals(matchedResults.get(index))) {
                        return ResultType.MATCHED;
                    }
                    final Alphabet alphabet = guess.find(index);
                    final long count = unmatchedAnswerCounts.getOrDefault(alphabet, DEFAULT_COUNT);
                    if (count > DEFAULT_COUNT) {
                        unmatchedAnswerCounts.put(alphabet, Math.subtractExact(count, DECREASE_COUNT_UNIT));
                        return ResultType.EXIST;
                    }
                    return ResultType.MISMATCHED;
                })
                .toList();
        return new Result(resultTypes);
    }
}
