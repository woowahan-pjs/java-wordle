package view;

import java.util.List;
import model.Result;
import model.Results;

public class OutputView {

    private static final int BOUNDARY_VALUE = 6;
    private static final String SEPARATOR = "/";
    public static void turnOutput(int turn, List<Results> resultsList) {
        System.out.println();
        System.out.println(turn + SEPARATOR + BOUNDARY_VALUE);
        output(resultsList);
    }

    public static void output(List<Results> resultsList) {
        System.out.println();
        for (Results results : resultsList) {
            for (Result result : results.convertToList()) {
                System.out.print(result.getResultMark());
            }
            System.out.println();
        }
        System.out.println();
    }
}
