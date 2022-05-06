package wordle.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class WordPoolGenerator {

	private static final int VALID_WORD_LENGTH = 5;
	private static final int ZERO = 0;
	private static final String DEFAULT_WORDS_TEXT_FILE_PATH = "src/main/resources/words.txt";
	private static final String NO_SUCH_FILE_MESSAGE = "존재하지 않는 파일입니다.";
	private static final String NOT_EXISTED_WORD_IN_FILE_MESSAGE = "파일에 단어가 존재하지 않습니다.";

	public static WordPool generateFromDefaultFile() {
		return generateFromFile(DEFAULT_WORDS_TEXT_FILE_PATH);
	}

	public static WordPool generateFromFile(String path) {
		List<String> words = readWordsFromFile(path);
		validateWordsSize(words);
		return new WordPool(words);
	}

	private static List<String> readWordsFromFile(String path) {
		try {
			return Files.lines(Paths.get(path))
				.filter(WordPoolGenerator::isValidWord)
				.collect(Collectors.toList());
		} catch (IOException e) {
			throw new IllegalArgumentException(NO_SUCH_FILE_MESSAGE);
		}
	}

	private static boolean isValidWord(String word) {
		// 단어가 5글자인지
		if (word.length() == VALID_WORD_LENGTH) {
			return true;
		}
		// 단어가 영문자로만 구성되어 있는지
		if (WordValidator.hasEnglishLetterOnly(word)) {
			return true;
		}
		return false;
	}

	private static void validateWordsSize(List<String> words) {
		if (words.size() == ZERO) {
			throw new IllegalArgumentException(NOT_EXISTED_WORD_IN_FILE_MESSAGE);
		}
	}
}
