package wordle.domain;

import java.util.List;
import wordle.exception.WordNotExistException;
import wordle.infra.FileReader;

public class FileWordBook implements WordBook {

    public static final String FILE_PATH = "words.txt";
    private final List<Word> words;

    public FileWordBook(FileReader fileReader) {
        this.words = fileReader.readByLine(FILE_PATH)
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

    @Override
    public Word find(String target) {
        Word targetWord = new Word(target);
        return words.stream()
                .filter(targetWord::equals)
                .findFirst()
                .orElseThrow(WordNotExistException::new);
    }
}
