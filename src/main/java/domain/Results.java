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
}
