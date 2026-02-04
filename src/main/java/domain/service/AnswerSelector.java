package domain.service;

import domain.model.WordCondition;
import domain.port.WordRepository;
import java.time.LocalDate;

public class AnswerSelector {

    private final WordRepository wordRepository;

    public AnswerSelector(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    public String selectAnswer() {
        int dayOfYear = LocalDate.now().getDayOfYear();
        int index = calculateIndex(dayOfYear);
        return wordRepository.getWordList().get(index);
    }

    private int calculateIndex(int dayOfYear) {
        int length = WordCondition.입력_제한_길이.getValue();
        int count = WordCondition.입력_제한_횟수.getValue();
        return (dayOfYear - 1) % (length * count);
    }
}
