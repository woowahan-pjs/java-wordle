package wordle.domain;

import wordle.util.FileReader;

import java.util.List;

public class WordBook {

    private final List<Word> words;

    public WordBook(final FileReader reader) {
        this.words = reader.readByLine("words.txt")
                .stream()
                .map(Word::new)
                .toList();
    }

    public String pick(final int index) {
        if (index < 0 || index >= words.size()) {
            throw new IndexOutOfBoundsException("Index out of bound");
        }
        return words.get(index).getValue();
    }

    public int getSize() {
        return words.size();
    }
}
