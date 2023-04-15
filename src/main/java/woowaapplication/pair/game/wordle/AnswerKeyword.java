package woowaapplication.pair.game.wordle;

import static woowaapplication.pair.game.wordle.WordleGameService.WORDS_FILE_NAME;

import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import woowaapplication.pair.game.wordle.exception.InvalidAnswerKeywordException;

public class AnswerKeyword {

    private final LocalDate standardDate = LocalDate.of(2021, 6, 19);
    private final String answerKeyword;

    public AnswerKeyword(LocalDate comparisonDate) {
        this.answerKeyword = generate(comparisonDate);
    }

    private String generate(LocalDate comparisonDate) {
        List<String> keywords = readKeywordsFromFile();

        if (keywords.isEmpty()) {
            throw new InvalidAnswerKeywordException();
        }

        int index = findAnswerKeywordIndex(keywords, standardDate, comparisonDate);

        return keywords.get(index);
    }

    private List<String> readKeywordsFromFile() {
        URL resource = getClass().getClassLoader().getResource(WORDS_FILE_NAME);
        return FileReader.readLinesFromFile(resource);
    }

    private int findAnswerKeywordIndex(List<String> keywords, LocalDate standardDate, LocalDate comparisonDate) {
        Period period = Period.between(standardDate, comparisonDate);

        return (period.getDays() % keywords.size()) - 1;
    }


    public WordleBlock[] convertToWordleBlocks(String inputKeyword) {
        WordleBlock[] resultBlocks = new WordleBlock[WordleGame.KEYWORD_LENGTH];
        Set<Character> answerLetters = createAnswerLetters();

        for (int index = 0; index < inputKeyword.length(); index++) {
            char inputLetter = inputKeyword.charAt(index);
            char answerLetter = answerKeyword.charAt(index);

            WordleBlock block = compareLetters(inputLetter, answerLetter, answerLetters);

            resultBlocks[index] = block;
        }

        return resultBlocks;
    }

    private HashSet<Character> createAnswerLetters() {
        return answerKeyword.chars()
                .mapToObj(letter -> (char) letter)
                .collect(Collectors.toCollection(HashSet::new));
    }

    private static WordleBlock compareLetters(char inputLetter, char answerLetter, Set<Character> answerLetters) {
        if (answerLetter == inputLetter) {
            return WordleBlock.CORRECT;
        }

        if (answerLetters.contains(inputLetter)) {
            return WordleBlock.EXIST_BUT_WRONG_SPOT;
        }

        return WordleBlock.WRONG;
    }

    public boolean isCorrect(String inputKeyword) {
        return answerKeyword.equals(inputKeyword);
    }
}
