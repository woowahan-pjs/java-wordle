package view.output;

import domain.Tiles;

public class OutputView {

    private OutputView() {
    }

    public static void printMain() {
        System.out.println("WORDLE을 6번 만에 맞춰 보세요.");
        System.out.println("시도의 결과는 타일의 색 변화로 나타납니다.");
    }

    public static void printInputAnswer() {
        System.out.println("정답을 입력해 주세요.");
    }

    public static void printTile(Tiles tiles) {
        System.out.println(tiles.print());
    }

    public static void printCount(int count, int endCount) {
        System.out.println("\n" + count + "/" + endCount + "\n");
    }
}
