package controller;

import java.util.Scanner;

public class WordInputHandler {

    public String inputWord() {
        while (true) {
            String input = new Scanner(System.in).nextLine().toLowerCase();
            try {
                validateInput(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }
        if (input.length() != 5) {
            throw new IllegalArgumentException("5글자를 입력해주세요.");
        }
    }
}
