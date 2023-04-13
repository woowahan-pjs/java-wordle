package domain;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Words {
    private final List<Word> words;

    public Words(String... words){
        this(Arrays.stream(words)
                .map(Word::new)
                .collect(Collectors.toList()));
    }

    public Words(List<Word> words) {
        this.words = Collections.unmodifiableList(words);
    }

    public Word answer(LocalDate from){
        Period period = Period.between(LocalDate.of(2021, 6, 19), from);
        int range = period.getDays()%words.size();
        return words.get(range);
    }

    public List<Color> matchingAnswer(Word input) {
        validate(input);
        Word answer = answer(LocalDate.now());
        return answer.compareWith(input);
    }

    private void validate(Word input) {
        if(!words.contains(input)){
            throw new IllegalArgumentException("단어집에 없는 단어를 선택하였습니다.");
        }
    }
}
