package wordle.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import wordle.model.WordPool;

public class WordPoolGenerator {

	public static final String WORDS_TEXT_FILE_PATH = "src/main/resources/words.txt";
	public static final String NO_SUCH_FILE_EXCEPTION_MESSAGE = "존재하지 않는 파일입니다.";

	public static WordPool generate() {
		try {
			return new WordPool(Files.readAllLines(Paths.get(WORDS_TEXT_FILE_PATH)));
		} catch (IOException e) {
			throw new IllegalArgumentException(NO_SUCH_FILE_EXCEPTION_MESSAGE);
		}
	}
}
