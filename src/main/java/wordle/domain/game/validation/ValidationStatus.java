package wordle.domain.game.validation;

public enum ValidationStatus {
    VALID,
    NOT_IN_DICTIONARY,
    INVALID_LENGTH,
    NOT_ALPHABET,
    NULL_INPUT
}
