package woowaapplication.pair.game.wordle;

import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WordleGame {

    public static final String WORDS_FILE_NAME = "words.txt";
    public static final int TOTAL_CHANCE = 6;
    public static final int KEYWORD_LENGTH = 5;

    private final Coin coin;

    private final LocalDate standardDate = LocalDate.of(2021, 6, 19);
    private final LocalDate comparisonDate;

    // TODO: LocalDate.now() 좀 더 좋은 테스트 방법 생각해보기
    public WordleGame(Coin coin, LocalDate comparisonDate) {
        this.coin = coin;
        this.comparisonDate = comparisonDate;
    }

    public WordleGame(Coin coin) {
        this.coin = coin;
        this.comparisonDate = LocalDate.now();
    }

    public int getRestChance() {
        return coin.getRestChance();
    }

    public PlayResult play(String inputKeyword) {
        // 유효성 검사 진행
        // Validator 객체
        // 유효성 검사 메서드
        boolean validateResult = KeywordValidator.validate(inputKeyword, KEYWORD_LENGTH);

        if (!validateResult) {
            throw new IllegalArgumentException("잘못된 입력 값입니다");
        }

        //  정답 체크
        WordleBlock[] resultBlocks = checkAnswer(inputKeyword);

        boolean isAnswer = Arrays.stream(resultBlocks)
                .allMatch(block -> block == WordleBlock.CORRECT);

        // 정답이 아니면 잔여 횟수 감소
        if (!isAnswer) {
            coin.decreaseChance();
        }

        return new PlayResult(resultBlocks, coin);
    }

    // 정답값

    // 정답 체크 메서드
    public WordleBlock[] checkAnswer(String inputKeyword) {
        String answerKeyword = getAnswerKeyword();

        return compareKeywords(inputKeyword, answerKeyword);
    }

    private WordleBlock[] compareKeywords(String inputKeyword, String answerKeyword) {
        WordleBlock[] resultBlocks = new WordleBlock[KEYWORD_LENGTH];

        Set<Character> answerLetters = answerKeyword.chars()
            .mapToObj(letter -> (char)letter)
            .collect(Collectors.toCollection(HashSet::new));

        for (int index = 0; index < inputKeyword.length(); index++) {
            char inputLetter = inputKeyword.charAt(index);
            char answerLetter = answerKeyword.charAt(index);

            WordleBlock block = compareLetters(inputLetter, answerLetter, answerLetters);

            resultBlocks[index] = block;
        }

        return resultBlocks;
    }

    private WordleBlock compareLetters(char inputLetter, char answerLetter, Set<Character> answerLetters) {
        if (answerLetter == inputLetter) {
            return WordleBlock.CORRECT;
        }

        if (answerLetters.contains(inputLetter)) {
            return WordleBlock.EXIST_BUT_WRONG_SPOT;
        }

        return WordleBlock.WRONG;
    }

    public String getAnswerKeyword() {
        List<String> keywords = readKeywordsFromFile();

        int index = findAnswerKeywordIndex(keywords);

        //TODO: 키워드가 null이라면 논리적 예외 발생 시켜주면 좋을 듯 함
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
