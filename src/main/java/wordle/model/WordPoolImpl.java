package wordle.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;

public class WordPoolImpl implements WordPool {

	private static final String BASE_DATE = "20210619";
	private final List<String> words;

	public WordPoolImpl(List<String> words) {
		this.words = Collections.unmodifiableList(words);
	}

	@Override
	public boolean contains(String word) {
		return words.contains(word);
	}

	@Override
	public String getTodayAnswerWord() {
		return words.get(calculateIndexForTodayAnswerWord());
	}

	private int calculateIndexForTodayAnswerWord() {
		return calculatePeriod() % words.size();
	}

	private int calculatePeriod() {
		LocalDate now = LocalDate.now();
		LocalDate past = LocalDate.parse(BASE_DATE, DateTimeFormatter.BASIC_ISO_DATE);
		return (int) past.until(now, ChronoUnit.DAYS);
	}
}
