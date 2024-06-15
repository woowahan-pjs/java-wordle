package wordle;

import java.time.LocalDate;
import java.util.ArrayList;
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
        String wordOfDay = words.getWordOfDay(now);
        Answer answer = new Answer(wordOfDay);

        TileHistory tileHistory = new TileHistory();
        int tryCount = 0;
        while (tryCount < 6) {
            ioView.printInputAnswerMessage();
            String input = ioView.inputAnswer();

            Input inputClass = new Input(input);

            if (inputClass.lessThan(5)) { // 5는 게임 규칙
                ioView.printNotEnoughLettersMessage();
                continue;
            }

            if (words.notContains(inputClass)) {
                ioView.printNotInWordListMessage();
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

    private String compareLetter(Answer answer, String input) {
        List<Letter> inputLetters = new ArrayList<>();
        char[] inputArr = input.toCharArray();
        for (int i = 0; i < inputArr.length; i++) {
            inputLetters.add(new Letter(i, inputArr[i]));
        }

        Result result = checkContainsValue(answer, inputLetters);

        return result.toString();
    }

    private Result checkContainsValue(Answer answer, List<Letter> inputLetters) {
        Result result = new Result(5);

        for (Letter inputLetter : inputLetters) {
            if (answer.equalsPositionAndValue(inputLetter)) {
                answer.decreaseCount(inputLetter);
                result.addGreenTile(inputLetter.getPosition());
            }
        }

        for (Letter inputLetter : inputLetters) {
            if (answer.canDecreaseCount(inputLetter)) {
                answer.decreaseCount(inputLetter);
                result.addYellowTile(inputLetter.getPosition());
            } else if (answer.canNotDecreaseCount(inputLetter)) {
                if (result.isNullOrNotGreenTile(inputLetter.getPosition())) {
                    result.addGrayTile(inputLetter.getPosition());
                }
            } else {
                result.addGrayTile(inputLetter.getPosition());
            }
        }

        return result;
    }
}
