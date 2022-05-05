package wordle.mock;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;
import wordle.model.Words;

public class MockWordPool implements Words {

	private static final String BASE_DATE = "20210619";
	private static final String NOW_DATE = "20220505";
	private final List<String> words;

	public MockWordPool(List<String> words) {
		this.words = Collections.unmodifiableList(words);
	}

	public String getTodayAnswerWord() {
		return words.get(calculateIndexForTodayAnswerWord());
	}

	private int calculateIndexForTodayAnswerWord() {
		return calculatePeriod() % words.size();
	}

	private int calculatePeriod() {
		LocalDate now = LocalDate.parse(NOW_DATE, DateTimeFormatter.BASIC_ISO_DATE);
		LocalDate past = LocalDate.parse(BASE_DATE, DateTimeFormatter.BASIC_ISO_DATE);
		return (int) past.until(now, ChronoUnit.DAYS);
	}

	public boolean contains(String word) {
		return words.contains(word);
	}

	public int size() {
		return words.size();
	}
}
