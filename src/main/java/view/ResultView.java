package view;

import domain.GameResult;
import domain.GameStatus;
import domain.LetterResult;
import domain.LetterResults;

import java.util.stream.Collectors;

public class ResultView {
    private static final String WIN_END_VIEW = " / 6";

    public void view(final GameStatus gameStatus, final GameResult gameResult) {
        if (gameStatus == GameStatus.WIN) {
            System.out.println(gameResult.getResults().size() + WIN_END_VIEW);
        }
        gameResult.getResults().stream().map(this::changeTiles).forEach(System.out::println);
    }

    private String changeTiles(final LetterResults letterResults) {
        return letterResults.getList().stream().map(this::changeTile).collect(Collectors.joining());
    }

    private String changeTile(final LetterResult letterResult) {
        if (letterResult == LetterResult.GREEN) {
            return "\uD83D\uDFE9";
        }
        if (letterResult == LetterResult.YELLOW) {
            return "\uD83D\uDFE8";
        }
        return "⬜";
    }
}
