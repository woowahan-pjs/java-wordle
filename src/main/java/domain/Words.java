package domain;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

public class Words {
    private final List<Word> words;

    public Words(List<String> words) {
        this.words = convert(words);
    }

    private List<Word> convert(List<String> words) {
        if (words.size() == 0) {
            throw new IllegalArgumentException("파일이 비어 있습니다.");
        }

        return words.stream().map(Word::new).collect(Collectors.toList());
    }

    public Word getResult(LocalDate now) {
        long between = ChronoUnit.DAYS.between(LocalDate.of(2021, 6, 19), now);

        return this.words.get((int) (between % words.size()));
    }

    public List<Word> getWords() {
        return words;
    }
}
