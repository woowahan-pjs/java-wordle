package game;

import camp.nextstep.edu.missionutils.Console;
import domain.Answer;
import domain.MatchResult;
import domain.MatchResults;
import domain.Tiles;
import domain.TilesBucket;

import java.time.LocalDate;

public class Game {

    private final Answer answer;
    private final TilesBucket tilesBucket;
    private final MatchResults matchResults;
    private final Round round;
    private Tiles inputTiles;

    public Game() {
        this.tilesBucket = new TilesBucket("src/main/resources/words.txt");
        this.answer = tilesBucket.getAnswer(LocalDate.now());
        this.matchResults = new MatchResults();
        this.round = new Round();
    }

    public void play() {
        System.out.println("WORDLE을 6번 만에 맞춰 보세요.\n시도의 결과는 타일의 색 변화로 나타납니다.");

        boolean isCorrect = false;
        while (!round.isFinish() && !isCorrect) {
            round.nextRound();
            inputTiles();
            isCorrect = isCorrectWords();
            if (isCorrect) {
                System.out.println(round);
            }
            matchResults.print();

        }
        if (!isCorrect) {
            System.out.println("오늘의 정답: " + answer);
        }
    }

    private void inputTiles() {
        do {
            System.out.println("정답을 입력해 주세요.");
        } while (doInputTilesSuccess());
    }

    private boolean doInputTilesSuccess() {
        try {
            this.inputTiles = new Tiles(Console.readLine());
            boolean bucketContains = tilesBucket.contains(inputTiles);

            if (!bucketContains) {
                System.out.println("단어리스트에 없는 단어입니다.");
            }
            return !bucketContains;
        } catch (final IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private boolean isCorrectWords() {
        final MatchResult result = answer.matches(inputTiles);
        matchResults.getMatchResults().add(result);
        return result.isCorrect();
    }
}
