package view;

import model.WordResult;

import java.util.ArrayList;
import java.util.List;

public class WordDrawer {

    private final List<WordResult> history = new ArrayList<>();

    public void addResult(WordResult result) {
        history.add(result);
    }

    public void showPrompt() {
        StringBuilder sb = new StringBuilder();
        for (WordResult result : history) {
            for (String s : result.getTiles()) {
                sb.append(s);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void showTheEnd(boolean solved) {
        if (solved) {
            System.out.println("축하합니다! 정답을 맞추셨습니다.");
            return;
        }
        System.out.println("실패! 게임이 종료됩니다.");
    }
}
