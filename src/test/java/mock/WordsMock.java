package mock;

import domain.Letters;
import domain.Words;

import java.util.List;

public class WordsMock implements Words {

    private final List<Letters> words = List.of(
            Letters.of("hello"),
            Letters.of("hello"),
            Letters.of("story"),
            Letters.of("glory"),
            Letters.of("apple"),
            Letters.of("model"),
            Letters.of("karma"),
            Letters.of("grade"),
            Letters.of("quiet"),
            Letters.of("bench"),
            Letters.of("major")
    );

    @Override
    public Letters getTodayWords() {
        return Letters.of("hello");
    }

    @Override
    public boolean contains(Letters letter) {
        return words.contains(letter);
    }
}
