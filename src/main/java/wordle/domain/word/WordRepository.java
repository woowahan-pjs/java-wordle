package wordle.domain.word;

import java.util.List;

public interface WordRepository {

    boolean hasWord(String word);

    List<String> getWordList();
}
