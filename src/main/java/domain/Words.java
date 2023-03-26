package domain;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Words {

    private static final Pattern pattern = Pattern.compile("^[a-zA-Z]*");

    private final List<String> words;

    public Words(List<String> words) {
        if (words.size() == 0) {
            throw new IllegalStateException("파일이 비어 있습니다.");
        }

        List<String> filterWords = words.stream()
                .filter(word -> word.length() == 5)
                .filter(word -> pattern.matcher(word).matches())
                .collect(Collectors.toList());

        if (filterWords.size() == 0) {
            throw new IllegalStateException("5글자인 단어가 존재하지 않습니다.");
        }

        this.words = filterWords;
    }

    public List<String> getWords() {
        return words;
    }
}
