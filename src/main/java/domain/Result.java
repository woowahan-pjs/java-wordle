package domain;

import java.util.List;
import java.util.Objects;

public class Result {

	private static final int RESULT_SIZE = 5;
	private final List<MatchStatus> statuses;

	public Result(List<MatchStatus> statuses) {
		validateSize(statuses);
		this.statuses = statuses;
	}

	private void validateSize(List<MatchStatus> statuses) {
		if (statuses.size() != RESULT_SIZE) {
			throw new IllegalArgumentException(String.format("결과의 크기는 %d개 여야 합니다.", RESULT_SIZE));
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Result result = (Result)o;

		return Objects.equals(statuses, result.statuses);
	}

	@Override
	public int hashCode() {
		return statuses != null ? statuses.hashCode() : 0;
	}

	@Override
	public String toString() {
		StringBuilder print = new StringBuilder();
		for (MatchStatus status : statuses) {
			print.append(status);
		}
		return print.toString();
	}
}
