package woowaapplication.pair.game.wordle;

import java.util.Scanner;

public class WordleGameController {

    public void execute() {
        String todayKeyword = AnswerKeywordInitializer.getTodayKeyword();
        Coin coin = new Coin(WordleGame.TOTAL_CHANCE);

        WordleGame wordleGame = new WordleGame(coin);

        Scanner sc = new Scanner(System.in);

        while (wordleGame.getRestChance() > 0) {

            String inputKeyword = sc.nextLine();

            PlayResult result = wordleGame.play(inputKeyword);
            // 실패 시 누적된 결과값을 출력 - 누적된 네모칸들

        }

        // 성공돼서 break 됐을 때 누적된 결과값을 출력 - 잔여 횟수 & 누적된 네모칸들


    }

    // 입력 받는 메서드
    // 출력 하는

}
