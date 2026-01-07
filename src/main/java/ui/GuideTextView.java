package ui;

public class GuideTextView {
    public void render(int roundLimit) {
        System.out.printf("WORDLE을 %d번 만에 맞춰 보세요.\n", roundLimit);
        System.out.println("시도의 결과는 타일의 색 변화로 나타납니다.");
    }
}
