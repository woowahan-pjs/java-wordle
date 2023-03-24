package woowaapplication.pair.game.wordle;

import java.util.Arrays;

public class WordleGame {

    public static final int TOTAL_CHANCE = 6;
    private final String answerKeyword;
    private final Coin coin;

    public WordleGame(String answerKeyword, Coin coin) {
        this.answerKeyword = answerKeyword;
        this.coin = coin;
    }

    public PlayResult play(String inputKeyword) {
        // 유효성 검사 진행
        // Validator 객체
        // 유효성 검사 메서드
        boolean validateResult = KeywordValidator.validate(inputKeyword);

        if (!validateResult) {
            throw new IllegalArgumentException("잘못된 입력 값입니다");
        }

        //  정답 체크
        WordleBlock[] checkResult = checkAnswer(inputKeyword);

        boolean isAnswer = Arrays.stream(checkResult)
                .allMatch(res -> res == WordleBlock.CORRECT);

        // 정답이 아니면 잔여 횟수 감소
        if (!isAnswer) {
            coin.decreaseChance();
        }

        PlayResult result = new PlayResult(checkResult, coin);

        return result;
    }

    // 정답값

    // 정답 체크 메서드
    public WordleBlock[] checkAnswer(String inputKeyword) {
        // keyword 가 정답인지 체크 후 맞는 문자열 반환
        WordleBlock[] result = new WordleBlock[5];

        return result;
    }

    public int getRestChance() {
        return coin.getRestChance();
    }
}
