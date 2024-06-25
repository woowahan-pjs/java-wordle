package wordle.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Result {
    private final List<ResultType> resultTypes;

    public Result(final List<ResultType> resultTypes) {
        this.resultTypes = resultTypes;
    }

    public boolean allMatched() {
        return resultTypes.stream().allMatch(ResultType.MATCHED::equals);
    }

    public ResultType get(final int index) {
        return resultTypes.get(index);
    }

    public List<ResultType> getResult() {
        return Collections.unmodifiableList(resultTypes);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Result result = (Result) o;
        return Objects.equals(resultTypes, result.resultTypes);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(resultTypes);
    }
}
