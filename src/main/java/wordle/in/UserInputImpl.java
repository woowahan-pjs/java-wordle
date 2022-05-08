package wordle.in;

import java.util.Scanner;
import wordle.domain.design.UserInput;
import wordle.domain.exception.WrongUserWordException;
import wordle.domain.vo.UserWord;

public class UserInputImpl implements UserInput {

    private final Scanner sc;

    public UserInputImpl() {
        this.sc = new Scanner(System.in);
    }

    @Override
    public UserWord execute() throws WrongUserWordException {
        String userInput = sc.nextLine();
        return UserWord.of(userInput);
    }

    @Override
    public void end() {
        sc.close();
    }
}
