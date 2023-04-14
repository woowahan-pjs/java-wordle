package ui;

import domain.Colors;
import domain.TryResult;

import java.util.List;

public class ResultView {

    private ResultView(){}

    public static void startComent() {
        System.out.println("WORDLE을 6번 만에 맞춰 보세요.\n시도의 결과는 타일의 색 변화로 나타납니다.\n");
    }

    public static void results(TryResult tryResult) {
        List<Colors> results = tryResult.getResults();
        if (tryResult.isFinished()) {
            System.out.println(String.format("%d/6", tryResult.count()));
        }

        for (Colors colors : results) {
            System.out.println(colors);
        }
    }
}
