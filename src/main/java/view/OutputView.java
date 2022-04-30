package view;

import java.util.List;
import java.util.Map;
import model.Result;
import model.Results;

public class OutputView {

    private static final int BOUNDARY_VALUE = 6;

    private static final Map<Result, String> RESULT_MARK = Map.of(
            Result.MATCH, "🟩",
            Result.EXIST, "🟨",
            Result.NON_EXIST, "⬜"
    );

    public static void turnOutput(int turn) {
        System.out.println(turn + "/" + BOUNDARY_VALUE);
    }

    public static void output(List<Results> resultsList) {
        System.out.println();
        for (Results results : resultsList) {
            for (Result result : results.getResults()) {
                System.out.print(RESULT_MARK.get(result));
            }
            System.out.println();
        }
        System.out.println();
    }
}
