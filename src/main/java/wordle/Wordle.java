package wordle;

import java.time.LocalDate;
import java.util.List;

public class Wordle {

    private static final String ANSWER_TILE = "\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9";

    private final IOView ioView;
    private final WordsReader wordsReader;

    public Wordle(IOView ioView, WordsReader wordsReader) {
        this.ioView = ioView;
        this.wordsReader = wordsReader;
    }

    public void start() {
        ioView.printInitGameMessage();

        List<String> wordList = wordsReader.read();
        Words words = new Words(wordList, LocalDate.of(2021, 6, 19));
        LocalDate now = LocalDate.now();
        String answer = words.getWordOfDay(now);

        TileHistory tileHistory = new TileHistory();
        int tryCount = 0;
        while (tryCount < 6) {
            ioView.printInputAnswerMessage();
            String input = ioView.inputAnswer();

            if (input.length() < 5) {
                ioView.printNotEnoughLettersMessage();
                continue;
            }

            if (words.notContains(input)) {
                ioView.printNotInWordListMessage();
                continue;
            }

            String tile = compareLetter(answer, input);
            tileHistory.add(tile);

            // 정답이면 탈출, 6번 초과 실패
            if (ANSWER_TILE.equals(tile)) {
                // 정답 여부만 체크
                ioView.printTryCount(tryCount + 1, 6);
                ioView.printHistories(tileHistory);
                break;
            }

            if (tryCount >= 5 && !ANSWER_TILE.equals(tile)) {
                ioView.printTryCount("X", 6);
                ioView.printHistories(tileHistory);
                break;
            }

            ioView.printHistories(tileHistory);

            tryCount++;
        }
    }

    private String compareLetter(String answer, String input) {
        char[] answerArr = answer.toCharArray();
        char[] inputArr = input.toCharArray();
        Result result = checkContainsValue(answerArr, inputArr);

        return result.toString();
    }

    private Result checkContainsValue(char[] answerArr, char[] inputArr) {
        Answer answer = new Answer(answerArr);
        Result result = new Result(5);

        for (int i = 0; i < 5; i++) {
            char input = inputArr[i];
            if (answer.equalsPositionAndCharacter(i, input)) {
                answer.decreaseCount(input);

                result.addGreenTile(i);
            }
        }

        for (int i = 0; i < 5; i++) {
            char input = inputArr[i];
            if (answer.canDecreaseCount(input)) {
                answer.decreaseCount(input);
                result.addYellowTile(i);
            } else if (answer.canNotDecreaseCount(input)) {
                if (result.isNullOrNotGreenTile(i)) {
                    result.addGrayTile(i);
                }
            } else {
                result.addGrayTile(i);
            }
        }

        return result;
    }
}
