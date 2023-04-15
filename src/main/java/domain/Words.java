package domain;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

public class Words {
    public static final LocalDate DEFAULT_DATE = LocalDate.of(2021, 6, 19);
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

    public Answer getAnswer(LocalDate now) {
        long betweenDay = ChronoUnit.DAYS.between(DEFAULT_DATE, now);

        Word answer = this.words.get((int) (betweenDay % words.size()));
        return new Answer(answer);
    }

    public Word getWord(String word) {
        Word inputWord = new Word(word);
        validateExist(inputWord);
        return inputWord;
    }

    private void validateExist(Word word) {
        if (!words.contains(word)) {
            throw new IllegalArgumentException("존재하지 않는 단어입니다.");
        }
    }

    public List<Word> getWords() {
        return words;
    }
}
