package wordle;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wordle {

    private static final String GRAY_TILE = "⬜";
    private static final String YELLOW_TILE = "\uD83D\uDFE8";
    private static final String GREEN_TILE = "\uD83D\uDFE9";
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

    /**
     * 단어 비교 기능
     * - 각 자리의 단어가 같은지 체크하는 기능
     * - 자리가 같지 않아도 단어가 포함되는지 체크하는 기능 (개수도 체크가 되어야 한다.)
     * - 우선순위는 1번이므로 하나씩 덮어쓰면 된다
     */
    private static String compareLetter(String answer, String input) {
        char[] answerArr = answer.toCharArray();
        char[] inputArr = input.toCharArray();
        String[] result = new String[5];

        checkContainsValue(answerArr, inputArr, result);
        return String.join("", result);
    }

    /**
     * 포함하지 않으면 회색
     * 포함하면 노란색(그런데 개수도 같아야 함)
     */
    private static void checkContainsValue(char[] answerArr, char[] inputArr, String[] result) {
        Map<Character, Integer> answerCharacterCountMap = createCharacterCountMap(answerArr);

        // 초록색 먼저하고 선차감
        for (int i = 0; i < 5; i++) {
            char input = inputArr[i];
            if (answerArr[i] == input) {
                answerCharacterCountMap.put(input, answerCharacterCountMap.get(input) - 1);
                result[i] = GREEN_TILE;
            }
        }

        for (int i = 0; i < 5; i++) {// ㅇㅣㄴ덱스
            char input = inputArr[i];  // 입력한 값
            if (answerCharacterCountMap.containsKey(input) && answerCharacterCountMap.get(input) > 0) {
                answerCharacterCountMap.put(input, answerCharacterCountMap.get(input) - 1);  // 개수 차감
                result[i] = YELLOW_TILE;
            } else if (answerCharacterCountMap.containsKey(input) && answerCharacterCountMap.get(input) <= 0) {  // 개수가 없을떄
                if (result[i] == null || !result[i].equals(GREEN_TILE)) {
                    result[i] = GRAY_TILE;
                }
            } else {
                result[i] = GRAY_TILE;
            }
        }
    }

    private static Map<Character, Integer> createCharacterCountMap(char[] answerArr) {
        Map<Character, Integer> characterCountMap = new HashMap<>();
        for (char answerChar : answerArr) {
            characterCountMap.put(answerChar, characterCountMap.getOrDefault(answerChar, 0) + 1);
        }
        return characterCountMap;
    }
}
