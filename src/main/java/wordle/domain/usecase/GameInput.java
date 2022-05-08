package wordle.domain.usecase;

import wordle.domain.design.MessagePrinter;
import wordle.domain.design.UserInput;
import wordle.domain.exception.WrongUserWordException;
import wordle.domain.vo.Message;
import wordle.domain.vo.UserWord;

public class GameInput {

    private MessagePrinter messagePrinter;
    private UserInput userInput;

    public GameInput(MessagePrinter messagePrinter, UserInput userInput) {
        this.messagePrinter = messagePrinter;
        this.userInput = userInput;
    }

    public UserWord execute() {
        try {
            messagePrinter.execute(Message.USER_INPUT);
            return userInput.execute();
        } catch (WrongUserWordException e) {
            messagePrinter.execute(Message.WRONG_INPUT);
            return execute();
        }
    }

    public void end() {
        userInput.end();
    }
}
