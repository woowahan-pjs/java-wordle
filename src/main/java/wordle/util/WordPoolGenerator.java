package wordle.util;

import static java.nio.file.Files.newBufferedReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import wordle.model.WordPool;

public class WordPoolGenerator {

	public static final String WORDS_TEXT_FILE_PATH = "src/main/resources/words.txt";
	private static final String NO_SUCH_FILE_EXCEPTION_MESSAGE = "존재하지 않는 파일입니다.";
	private static final int VALID_WORD_LENGTH = 5;

	public static WordPool generate(String path) {
		List<String> words = new ArrayList<>();
		String word = null;

		// todo:refactor: depth 줄이기
		try (BufferedReader reader = newBufferedReader(Paths.get(path))) {
			do {
				word = reader.readLine();
				if (word != null && word.length() == VALID_WORD_LENGTH) {
					words.add(word);
				}
			} while (word != null);
		} catch (IOException e) {
			throw new IllegalArgumentException(NO_SUCH_FILE_EXCEPTION_MESSAGE);
		}

		return new WordPool(words);
	}

	// todo 파일에 단어가 1개이상 존재해야 한다. 단어가 0개면 예외처리
}
