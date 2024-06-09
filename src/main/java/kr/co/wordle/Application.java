package kr.co.wordle;

public class Application {
    public static void main(String[] args) {
        Answer answer = new Answer();
        Console console = new Console();
        console.init();

        String input = console.inputView();
        Round round = new Round(input);
        round.roundResult(answer);
    }
}
