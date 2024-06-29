package wordle.domain;

import java.util.Optional;

public interface WordBook {

    Word pick(AnswerFormula answerFormula);

    boolean exist(Word word);

    Optional<Word> find(String word);
}
