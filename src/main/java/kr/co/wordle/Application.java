package kr.co.wordle;

public class Application {
    public static void main(String[] args) {
        Console console = new Console();
        console.init();
        String input = console.inputView();
        Answer answer = new Answer();
        answer.roundResult(input);
    }
}
