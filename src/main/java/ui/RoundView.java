package ui;

public class RoundView {
    public void render(int current, int max) {
        System.out.printf("%d/%d%n", current, max);
    }

    public void renderLoseGame() {
        System.out.print("시도 가능 횟수가 종료되었습니다.");
    }
}
