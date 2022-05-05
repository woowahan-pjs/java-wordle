package wordle.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import wordle.model.WordPool;

public class WordPoolGenerator {

	private static final String DEFAULT_WORDS_TEXT_FILE_PATH = "src/main/resources/words.txt";
	private static final int VALID_WORD_LENGTH = 5;
	private static final int INVALID_WORDS_SIZE = 0;
	private static final String NO_SUCH_FILE_EXCEPTION_MESSAGE = "존재하지 않는 파일입니다.";
	private static final String NOT_EXISTED_WORD_IN_FILE_MESSAGE = "파일에 단어가 존재하지 않습니다.";

	public static WordPool generate() {
		return generate(DEFAULT_WORDS_TEXT_FILE_PATH);
	}

	public static WordPool generate(String path) {
		List<String> words;
		words = readWordsFromFile(path);
		words = filterWordAsFiveLetters(words);
		validateWordsSize(words);
		return new WordPool(words);
	}

	private static List<String> filterWordAsFiveLetters(List<String> words) {
		return words.stream().filter(word -> word.length() == VALID_WORD_LENGTH)
			.collect(Collectors.toList());
	}

	private static List<String> readWordsFromFile(String path) {
		List<String> words;
		try {
			words = Files.readAllLines(Paths.get(path));
		} catch (IOException e) {
			throw new IllegalArgumentException(NO_SUCH_FILE_EXCEPTION_MESSAGE);
		}
		return words;
	}

	private static void validateWordsSize(List<String> words) {
		if (words.size() == INVALID_WORDS_SIZE) {
			throw new IllegalArgumentException(NOT_EXISTED_WORD_IN_FILE_MESSAGE);
		}
	}
}
