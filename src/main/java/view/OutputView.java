package view;

import domain.Results;

public class OutputView {
    private static final String NEXT_LINE = "\n";
    private static final String FINAL_ROUND_TEXT = "/6";

    public void print(Results results) {
        System.out.println(NEXT_LINE + results);
    }

    public void printRount(int roundNumber) {
        System.out.println(roundNumber + FINAL_ROUND_TEXT);

    }
}
