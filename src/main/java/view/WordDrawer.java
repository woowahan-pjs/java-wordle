package view;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class WordDrawer {

    static List<String[]> list = new ArrayList<>();
    static final String WHITE= "⬜";
    static final String YELLOW = "🟨";
    static final String GREEN = "🟩";

    public static void draw(List<Integer> partialMatchedIndexes, List<Integer> perfectlyMatchedIndexes) {

        String[] result = new String[5];
        Arrays.fill(result, WHITE);

        for (int partialMatchedIndex : partialMatchedIndexes) {
            result[partialMatchedIndex] = YELLOW;
        }

        for (int perfectlyMatchedIndex : perfectlyMatchedIndexes) {
            result[perfectlyMatchedIndex] = GREEN;
        }

        list.add(result);
    }

    public static void showPrompt(int trials) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < trials; i++) {
            for (String s : list.get(i)) {
                sb.append(s);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void showTheEnd(boolean gameOver, int trials) {
        if (gameOver) {
            System.out.println(trials + "번 만에 성공! 게임 종료");
        } else {
            System.out.println("실패! 게임 종료");
        }
    }
}
