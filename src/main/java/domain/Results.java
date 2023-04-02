package domain;

import java.util.ArrayList;
import java.util.List;

public class Results {

	private List<Result> results;

	public Results() {
		this.results = new ArrayList<>();
	}

	public void add(Result result) {
		results.add(result);
	}

	public int size() {
		return results.size();
	}

	public boolean hasCorrect() {
		List<MatchStatus> greenStatuses = List.of(
			MatchStatus.GREEN,
			MatchStatus.GREEN,
			MatchStatus.GREEN,
			MatchStatus.GREEN,
			MatchStatus.GREEN
		);
		Result greenResult = new Result(greenStatuses);
		return results.contains(greenResult);
	}

	@Override
	public String toString() {
		StringBuilder print = new StringBuilder();
		for (Result result : results) {
			print.append(result).append("\n");
		}
		return print.toString();
	}

}
