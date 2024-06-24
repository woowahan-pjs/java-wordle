package wordle.domain;

@FunctionalInterface
public interface AnswerFormula {

    int calculate(int wordCount);
}
