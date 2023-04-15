package domain;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Words {

    public static final LocalDate START_DATE = LocalDate.of(2021, 6, 19);
    private final List<Word> words;

    public Words(String... words) {
        this(Arrays.stream(words)
            .map(Word::new)
            .collect(Collectors.toList()));
    }

    public Words(List<Word> words) {
        this.words = Collections.unmodifiableList(words);
    }

    public boolean contains(Word word) {
        return words.contains(word);
    }

    public Word answer(LocalDate from) {
        Period period = Period.between(START_DATE, from);
        int range = period.getDays() % words.size();
        return words.get(range);
    }

    public Colors matchingAnswer(Word input) {
        validate(input);
        Word answer = answer(LocalDate.now());
        return answer.compareWith(input);
    }

    private void validate(Word input) {
        if (!words.contains(input)) {
            throw new IllegalArgumentException("단어집에 없는 단어를 선택하였습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Words words1 = (Words) o;
        return Objects.equals(words, words1.words);
    }

    @Override
    public int hashCode() {
        return Objects.hash(words);
    }
}
