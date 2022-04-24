package wordle.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class WordsGenerator {

	public static final String WORDS_TEXT_FILE_PATH = "src/main/resources/words.txt";
	public static final String NO_SUCH_FILE_EXCEPTION_MESSAGE = "존재하지 않는 파일입니다.";

	public static List<String> generate() {
		try {
			return Files.readAllLines(Paths.get(WORDS_TEXT_FILE_PATH));
		} catch (IOException e) {
			throw new IllegalArgumentException(NO_SUCH_FILE_EXCEPTION_MESSAGE);
		}
	}
}
