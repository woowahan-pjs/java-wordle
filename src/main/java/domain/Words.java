package domain;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Words {

    private final List<Word> words;

    public Words(String... words) {
        this(Arrays.stream(words)
            .map(Word::new)
            .collect(Collectors.toList()));
    }

    public Words(List<Word> words) {
        this.words = Collections.unmodifiableList(words);
    }

    public Word answer(LocalDate from, LocalDate to) {
        Period period = Period.between(from, to);
        int range = period.getDays() % words.size();
        return words.get(range);
    }

    public Word getWord(String word) {
        Word input = new Word(word);
        if (!words.contains(input)) {
            throw new IllegalArgumentException("단어집에 없는 단어를 선택하였습니다.");
        }

        return input;
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
