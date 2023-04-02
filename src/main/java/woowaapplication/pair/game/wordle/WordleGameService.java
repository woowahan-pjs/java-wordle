package woowaapplication.pair.game.wordle;


import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import woowaapplication.pair.game.wordle.exception.InvalidAnswerKeywordException;

public class WordleGameService {

    public static final String WORDS_FILE_NAME = "words.txt";

    private final WordleGameStorage wordleGameStorage;

    private final LocalDate standardDate = LocalDate.of(2021, 6, 19);
    private final LocalDate comparisonDate;

    public WordleGameService(WordleGameStorage wordleGameStorage, LocalDate comparisonDate) {
        this.wordleGameStorage = wordleGameStorage;
        this.comparisonDate = comparisonDate;
    }

    public WordleGameService(WordleGameStorage wordleGameStorage) {
        this.wordleGameStorage = wordleGameStorage;
        this.comparisonDate = LocalDate.now();
    }

    public boolean isGameOver() {
        return wordleGameStorage.isGameOver() || wordleGameStorage.isClear();
    }

    public List<String[]> playRound(String inputKeyword) {
        String answerKeyword = getAnswerKeyword();
        WordleBlock[] wordleBlocks = WordleBlock.toList(inputKeyword, answerKeyword);

        wordleGameStorage.checkAnswer(wordleBlocks);
        wordleGameStorage.decreaseChance();

        return wordleGameStorage.convertHistoryToEmoji();
    }

    public String getAnswerKeyword() {
        List<String> keywords = readKeywordsFromFile();

        if (keywords.isEmpty()) {
            throw new InvalidAnswerKeywordException();
        }

        int index = findAnswerKeywordIndex(keywords);

        return keywords.get(index);
    }

    private List<String> readKeywordsFromFile() {
        URL resource = getClass().getClassLoader().getResource(WORDS_FILE_NAME);
        return FileReader.readLinesFromFile(resource);
    }

    private int findAnswerKeywordIndex(List<String> keywords) {
        Period period = Period.between(standardDate, comparisonDate);

        return (period.getDays() % keywords.size()) - 1;
    }

    public static WordleGameService of(WordleGameStorage wordleGameStorage) {
        return new WordleGameService(wordleGameStorage);
    }

    public static WordleGameService of(WordleGameStorage wordleGameStorage, LocalDate comparisonDate) {
        return new WordleGameService(wordleGameStorage, comparisonDate);
    }
}
