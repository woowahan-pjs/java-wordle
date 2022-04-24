package wordle.impl;

import java.util.Scanner;
import wordle.design.UserInput;
import wordle.vo.UserWord;

public class UserInputImpl implements UserInput {

    private static final String INSTRUCTION = "정답을 입력해주세요.";

    @Override
    public UserWord execute() {
        instructor();
        UserWord result = input();
        return result;
    }

    private void instructor() {
        System.out.println(INSTRUCTION);
    }

    private UserWord input() {
        try {
            Scanner sc = new Scanner(System.in);
            String userInput = sc.next();
            sc.close();
            return new UserWord(userInput);
        } catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
