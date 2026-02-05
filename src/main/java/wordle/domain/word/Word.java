package wordle.domain.word;

import wordle.domain.game.GameInput;
import wordle.domain.game.validation.InputValidator;
import wordle.domain.game.validation.ValidationStatus;
import wordle.domain.matching.AnswerComparator;
import wordle.domain.matching.MatchResult;

public class Word {

    private final Answer answer;
    private final InputValidator validator;
    private final AnswerComparator comparator;

    public Word(Answer answer, WordRepository wordRepository) {
        this.answer = answer;
        this.validator = new InputValidator(wordRepository);
        this.comparator = new AnswerComparator();
    }

    public ValidationStatus check(GameInput input) {
        return validator.check(input.value());
    }

    public MatchResult[] match(GameInput input) {
        return comparator.compare(input.value(), answer.value());
    }
}
