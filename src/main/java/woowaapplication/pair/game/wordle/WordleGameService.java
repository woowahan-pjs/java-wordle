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

    // TODO: LocalDate.now() 좀 더 좋은 테스트 방법 생각해보기
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

    // 정답 체크 메서드
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
}
