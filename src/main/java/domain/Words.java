package domain;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Words {

    private static final Pattern pattern = Pattern.compile("^[a-zA-Z]*");
    public static final int WORD_LENGTH = 5;

    private final List<String> words;

    public Words(List<String> words) {
        if (words.size() == 0) {
            throw new IllegalStateException("파일이 비어 있습니다.");
        }

        List<String> matchWords = this.getMatchWords(words);

        if (matchWords.size() == 0) {
            throw new IllegalStateException("5글자인 단어가 존재하지 않습니다.");
        }

        this.words = matchWords;
    }

    private List<String> getMatchWords(List<String> words) {
        return words.stream()
                    .filter(this::isMatchWord)
                    .collect(Collectors.toList());
    }

    private boolean isMatchWord(String word){
        return word.length() == WORD_LENGTH && pattern.matcher(word).matches();
    }

    public List<String> getMatchWords() {
        return words;
    }
}
