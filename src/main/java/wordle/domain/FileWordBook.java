package wordle.domain;

import java.util.List;
import wordle.infra.FileReader;

public class FileWordBook implements WordBook {

    private final List<Word> words;

    public FileWordBook(FileReader fileReader) {
        this.words = fileReader.readByLine("words.txt")
                .stream()
                .map(Word::new)
                .toList();
    }

    @Override
    public Word pick(AnswerFormula answerFormula) {
        int index = answerFormula.calculate(words.size());
        return words.get(index);
    }

    @Override
    public boolean exist(Word word) {
        return words.contains(word);
    }
}
