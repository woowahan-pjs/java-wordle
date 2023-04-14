package ui;

import domain.Word;

import java.util.Scanner;

public class InputView {
    private InputView(){}

    public static Word inputComment() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("정답을 입력해 주세요.\n");
        return new Word(scanner.nextLine());
    }
}
