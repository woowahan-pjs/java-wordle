package domain;

import java.time.LocalDate;
import java.time.Period;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Words {
    private static final LocalDate BASE_DATE_FOR_ANSWER = LocalDate.of(2021, 6, 19);
    private final List<Word> words;

    public Words(List<Word> words) {
        this.words = Collections.unmodifiableList(words);
    }

    public static Words of(List<String> strings) {
        return new Words(strings.stream().map(Word::new).collect(Collectors.toList()));
    }

    public Word answer(LocalDate from) {
        Period period = Period.between(BASE_DATE_FOR_ANSWER, from);
        int range = period.getDays() % words.size();
        return words.get(range);
    }

    public List<Color> matchingAnswer(Word input) {
        validate(input);
        Word answer = answer(LocalDate.now());
        return answer.compareWith(input);
    }

    private void validate(Word input) {
        if (!words.contains(input)) {
            throw new IllegalArgumentException("단어집에 없는 단어를 선택하였습니다.");
        }
    }
}
