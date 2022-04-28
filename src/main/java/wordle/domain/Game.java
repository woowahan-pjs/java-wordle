package wordle.domain;

import camp.nextstep.edu.missionutils.Console;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Answer answer;
    private final WordsBucket wordsBucket;
    private final List<WordsMatchResult> wordsMatchResults;
    private final Round round;
    private Words inputWords;

    public Game() {
        wordsBucket = new WordsBucket("src/main/resources/words.txt");
        answer = wordsBucket.findAnswer(LocalDate.now());
        wordsMatchResults = new ArrayList<>();
        round = new Round();
    }

    public void play() {
        System.out.println("WORDLE을 6번 만에 맞춰 보세요.\n시도의 결과는 타일의 색 변화로 나타납니다.");

        boolean isCorrect;
        do {
            round.start();
            inputWords();
            isCorrect = isCorrectWords();
            if (isCorrect) {
                System.out.println(round);
            }
            wordsMatchResults.forEach(v -> System.out.println(v.getMatchStatusList()));

        } while (!round.isFinish() && !isCorrect);

    }

    private boolean isCorrectWords() {
        final WordsMatchResult result = answer.matches(inputWords);
        wordsMatchResults.add(result);
        return result.isCorrect();
    }

    private void inputWords() {
        do {
            System.out.println("정답을 입력해 주세요.");
        } while (doInputWordsSuccess());
    }

    private boolean doInputWordsSuccess() {
        try {
            this.inputWords = new Words(Console.readLine());
            return !wordsBucket.contains(inputWords);
        } catch (final IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private static class Round {

        private static final int LAST_ROUND = 6;
        private int currentRound = 0;

        public boolean isFinish() {
            return currentRound >= LAST_ROUND;
        }

        public void start() {
            currentRound++;
        }

        @Override
        public String toString() {
            return currentRound + "/" + LAST_ROUND;
        }
    }

}
