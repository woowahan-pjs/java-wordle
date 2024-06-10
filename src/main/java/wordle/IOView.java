package wordle;

import java.util.Scanner;
import java.util.StringJoiner;

public class IOView {

    private final Scanner scanner = new Scanner(System.in);

    public void printInitGameMessage() {
        StringJoiner stringJoiner = new StringJoiner("\n");
        stringJoiner.add("WORDLE을 6번 만에 맞춰 보세요.");
        stringJoiner.add("시도의 결과는 타일의 색 변화로 나타납니다.");
        System.out.println(stringJoiner);
    }

    public void printInputAnswerMessage() {
        System.out.println("정답을 입력해 주세요.");
    }

    public String inputAnswer() {
        return scanner.nextLine();
    }
}
