package wordle.domain.game.validation;

import wordle.domain.word.WordCondition;
import wordle.domain.word.WordRepository;

import static java.util.Objects.isNull;

public class InputValidator {

    private static final int WORD_LENGTH = WordCondition.WORD_LENGTH.value();
    private static final String ALPHABET_PATTERN = "(?i)[a-z]+";

    private final WordRepository wordRepository;

    public InputValidator(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    public ValidationStatus check(String inputValue) {
        if (isNull(inputValue)) {
            return ValidationStatus.NULL_INPUT;
        }
        if (inputValue.length() != WORD_LENGTH) {
            return ValidationStatus.INVALID_LENGTH;
        }
        if (!inputValue.matches(ALPHABET_PATTERN)) {
            return ValidationStatus.NOT_ALPHABET;
        }
        if (!wordRepository.hasWord(inputValue)) {
            return ValidationStatus.NOT_IN_DICTIONARY;
        }

        return ValidationStatus.VALID;
    }
}
