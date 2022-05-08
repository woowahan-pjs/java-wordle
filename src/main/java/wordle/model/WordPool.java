package wordle.model;

public interface WordPool {

	String getTodayAnswerWord();

	boolean contains(String word);
}
