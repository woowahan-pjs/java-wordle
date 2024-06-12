package wordle.domain;

@FunctionalInterface
public interface AnswerFormula {

    long calculate(int wordCount);
}
