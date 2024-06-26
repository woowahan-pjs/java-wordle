package wordle.view;

import java.util.Scanner;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import wordle.model.Result;
import wordle.model.Results;

public class Console {

    private final Scanner scanner = new Scanner(System.in);

    public void printInitGameMessage() {
        StringJoiner stringJoiner = new StringJoiner("\n");
        stringJoiner.add("WORDLE을 6번 만에 맞춰 보세요.");
        stringJoiner.add("시도의 결과는 타일의 색 변화로 나타납니다.");
        System.out.println(stringJoiner);
    }

    public void printInputRequestMessage() {
        System.out.println("정답을 입력해 주세요.");
    }

    public String inputAnswer() {
        return scanner.nextLine();
    }

    public void print(Results results) {
        String tiles = results.stream()
                .map(this::convertToString)
                .collect(Collectors.joining("\n"));

        System.out.println(tiles);
    }

    private String convertToString(Result result) {
        return String.join("", result.getTiles());
    }
    
    public void printTryCount(int tryCount, int totalCount) {
        System.out.println(tryCount + "/" + totalCount);
    }

    public void printResult(int tryCount, int tryCountLimit, Results results) {
        printTryCount(tryCount, tryCountLimit);
        print(results);
    }

    public void printResult(int tryCountLimit, Results results) {
        printTryCount("X", tryCountLimit);
        print(results);
    }

    public void printTryCount(String tryCount, int totalCount) {
        System.out.println(tryCount + "/" + totalCount);
    }

    public void printInvalidLengthMessage() {
        System.out.println("Invalid length!");
    }

    public void printNotInWordListMessage() {
        System.out.println("Not in word list!");
    }
}
