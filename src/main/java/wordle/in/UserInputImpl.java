package wordle.in;

import java.util.Scanner;
import wordle.domain.design.UserInput;
import wordle.domain.vo.UserWord;

public class UserInputImpl implements UserInput {

    private static final String INSTRUCTION = "정답을 입력해주세요.";

    private final Scanner sc;

    public UserInputImpl() {
        this.sc = new Scanner(System.in);
    }

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
        String userInput = sc.nextLine();
        try {
            return UserWord.of(userInput);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            
        }
    }

    @Override
    public void end() {
        sc.close();
    }
}
