package domain;

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

    public List<Word> getWords() {
        return words;
    }
}
