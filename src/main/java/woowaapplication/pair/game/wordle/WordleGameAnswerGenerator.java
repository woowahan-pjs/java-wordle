package woowaapplication.pair.game.wordle;

import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import woowaapplication.pair.game.util.FileReader;
import woowaapplication.pair.game.wordle.exception.InvalidAnswerKeywordException;

public class WordleGameAnswerGenerator {

    public static final String WORDS_FILE_NAME = "words.txt";

    private static final LocalDate standardDate = LocalDate.of(2021, 6, 19);

    public static String getAnswerKeyword(LocalDate comparisonDate) {
        List<String> keywords = readKeywordsFromFile();

        if (keywords.isEmpty()) {
            throw new InvalidAnswerKeywordException();
        }

        int index = findAnswerKeywordIndex(keywords, comparisonDate);

        return keywords.get(index);
    }

    public static String getAnswerKeyword() {
        List<String> keywords = readKeywordsFromFile();
        LocalDate comparisonDate = LocalDate.now();

        if (keywords.isEmpty()) {
            throw new InvalidAnswerKeywordException();
        }

        int index = findAnswerKeywordIndex(keywords, comparisonDate);

        return keywords.get(index);
    }

    public static List<String> readKeywordsFromFile() {
        URL resource = WordleGameAnswerGenerator.class.getClassLoader().getResource(WORDS_FILE_NAME);
        return FileReader.readLinesFromFile(resource);
    }

    public static int findAnswerKeywordIndex(List<String> keywords, LocalDate comparisonDate) {
        Period period = Period.between(standardDate, comparisonDate);

        return (period.getDays() % keywords.size()) - 1;
    }
}
