package wordle.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class WordPoolGenerator {

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
		return new WordPoolImpl(words);
	}

	private static List<String> readWordsFromFile(String path) {
		try {
			return Files.lines(Paths.get(path))
				.filter(WordPoolGenerator::validate)
				.collect(Collectors.toList());
		} catch (IOException e) {
			throw new IllegalArgumentException(NO_SUCH_FILE_MESSAGE);
		}
	}

	private static boolean validate(String word) {
		WordValidator.validateFiveLetterWord(word);
		WordValidator.validateEnglishLetterOnly(word);
		return true;
	}

	private static void validateWordsSize(List<String> words) {
		if (words.size() == ZERO) {
			throw new IllegalArgumentException(NOT_EXISTED_WORD_IN_FILE_MESSAGE);
		}
	}
}
