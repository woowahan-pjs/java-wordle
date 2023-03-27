package woowaapplication.pair.game.wordle;

import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.List;

public class WordleGame {

    public static final String WORDS_FILE_NAME = "words.txt";
    public static final int TOTAL_CHANCE = 6;
    public static final int KEYWORD_LENGTH = 5;

    private final String answerKeyword;
    private final Coin coin;

    private final LocalDate referenceDate = LocalDate.of(2021, 6, 19);
    private final LocalDate currentDate;

    public WordleGame(String answerKeyword, Coin coin, LocalDate currentDate) {
        this.answerKeyword = answerKeyword;
        this.coin = coin;
        this.currentDate = currentDate;
    }

    public WordleGame(String answerKeyword, Coin coin) {
        this.answerKeyword = answerKeyword;
        this.coin = coin;
        this.currentDate = LocalDate.now();
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
        // keyword 가 정답인지 체크 후 맞는 문자열 반환
        WordleBlock[] result = new WordleBlock[5];

        String answerKeyword = getAnswerKeyword();

        // TODO : 정답 체크 후 결과 박스 만들기

        return result;
    }


    public String getAnswerKeyword() {
        List<String> keywords = readKeywordsFromFile();

        int index = findAnswerKeywordIndex(keywords);

        return keywords.get(index);
    }

    private List<String> readKeywordsFromFile() {
        URL resource = getClass().getClassLoader().getResource(WORDS_FILE_NAME);
        return FileReader.readLinesFromFile(resource);
    }

    private int findAnswerKeywordIndex(List<String> keywords) {
        Period period = Period.between(referenceDate, currentDate);

        return (period.getDays() % keywords.size()) - 1;
    }
}
