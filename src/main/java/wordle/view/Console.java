package wordle.view;

import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;
import wordle.model.Tiles;

public class Console {

    private final Scanner scanner = new Scanner(System.in);

    public void printInitGameMessage() {
        StringJoiner stringJoiner = new StringJoiner("\n");
        stringJoiner.add("WORDLE을 6번 만에 맞춰 보세요.");
        stringJoiner.add("시도의 결과는 타일의 색 변화로 나타납니다.");
        System.out.println(stringJoiner);
    }

    public void printInputRequestMessage() {
        System.out.println("정답을 입력해 주세요.");
    }

    public String inputAnswer() {
        return scanner.nextLine();
    }

    public void printTiles(List<Tiles> tiles) {
        for (Tiles tile : tiles) {
            System.out.println(tile);
        }
    }

    public void printTryCount(int tryCount, int totalCount) {
        System.out.println(tryCount + "/" + totalCount);
    }

    public void printResult(int tryCount, int tryCountLimit, List<Tiles> tiles) {
        printTryCount(tryCount, tryCountLimit);
        printTiles(tiles);
    }

    public void printResult(int tryCountLimit, List<Tiles> tiles) {
        printTryCount("X", tryCountLimit);
        printTiles(tiles);
    }

    public void printTryCount(String tryCount, int totalCount) {
        System.out.println(tryCount + "/" + totalCount);
    }

    public void printInvalidLengthMessage() {
        System.out.println("Invalid length!");
    }

    public void printNotInWordListMessage() {
        System.out.println("Not in word list!");
    }
}
