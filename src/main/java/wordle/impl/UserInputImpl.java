package wordle.impl;

import java.util.Scanner;
import wordle.design.UserInput;
import wordle.vo.UserWord;

public class UserInputImpl implements UserInput {

  private static final String INSTRUCTION = "정답을 입력해주세요.";
  private Scanner sc;

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
    try {
      String userInput = sc.next();
      return UserWord.of(userInput);
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }
}
