package wordle.domain.word;

import java.time.LocalDate;

public class AnswerSelector {

    private static final int WORD_LENGTH = WordCondition.WORD_LENGTH.value();
    private static final int MAX_TRY_COUNT = WordCondition.MAX_TRY_COUNT.value();
    private static final int ANSWER_POOL_SIZE = WORD_LENGTH * MAX_TRY_COUNT;

    private final WordRepository wordRepository;

    public AnswerSelector(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    public String pickAnswer() {
        int dayOfYear = LocalDate.now().getDayOfYear();
        int index = makeIndex(dayOfYear);
        return wordRepository.getWordList().get(index);
    }

    private int makeIndex(int dayOfYear) {
        return (dayOfYear - 1) % ANSWER_POOL_SIZE;
    }
}
