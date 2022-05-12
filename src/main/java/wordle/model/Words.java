package wordle.model;

public interface Words {

	String getTodayAnswerWord();

	boolean contains(String word);

	int size();
}
