package controller;

import java.util.Scanner;

public class WordInputHandler {

    private boolean validateInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("공백 입력! 글자를 입력해주세요.");
        }
        if (input.length() > 5) {
            throw new IllegalArgumentException("글자수 초과 입력! 다섯 글자를 입력해주세요.");
        }
        return true;
    }
    public String inputWord() {
        boolean inputSuccess = false;
        while (!inputSuccess) {
            String input = new Scanner(System.in).nextLine();
            try {
                inputSuccess = validateInput(input);
                return input.toLowerCase();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return "";
    }
}
