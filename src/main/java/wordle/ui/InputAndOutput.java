package wordle.ui;

import wordle.domain.Tile;

import java.util.List;
import java.util.Scanner;

public class InputAndOutput {

    private final Scanner scanner = new Scanner(System.in);

    public void printWelcome() {
        System.out.printf("WORDLE을 %d번 만에 맞춰 보세요.\n", 6);
        System.out.println("시도의 결과는 타일의 색 변화로 나타납니다.");
    }

    public String askAnswer() {
        System.out.println("정답을 입력해 주세요.");
        return scanner.nextLine().trim();
    }

    public void printInvalidInputMessage(final String message) {
        System.out.println("[안내] " + message);
    }

    public void printHistory(final List<Tile[]> history) {
        System.out.println();
        for (Tile[] tiles : history) {
            for (Tile tile : tiles) {
                System.out.print(tile.getColor());
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printAttemptCount(int currentAttempt, int maxAttempts) {
        System.out.println();
        System.out.println(currentAttempt + "/" + maxAttempts);
    }

    public void printEndFail() {
        System.out.println("정답 맞추기에 실패했습니다.");
    }
}
