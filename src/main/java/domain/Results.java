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


	@Override
	public String toString() {
		StringBuilder print = new StringBuilder();
		for (Result result : results) {
			print.append(result).append("\n");
		}
		return print.toString();
	}
}
