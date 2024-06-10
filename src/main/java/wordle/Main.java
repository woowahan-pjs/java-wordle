package wordle;

public class Main {

    public static void main(String[] args) {
        IOView ioView = new IOView();
        ioView.printInitGameMessage();
        ioView.printInputAnswerMessage();
        String input = ioView.inputAnswer();
    }
}
