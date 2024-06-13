package wordle.domain;

public interface WordBook {

    Word pick(AnswerFormula answerFormula);

    boolean exist(Word word);
}
