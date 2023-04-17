package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.time.LocalDate;

public class Game {
    private static final String FILE_PATH = "src/main/resources/words.txt";
    private final InputView inputView;
    private final InputValidator inputValidator;
    private final OutputView outputView;
    private final AnswerGenerator answerGenerator;
    private final Results results;
    private int roundNumber;

    public Game() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.answerGenerator = new AnswerGenerator(FILE_PATH);
        this.results = new Results();
        this.roundNumber = 0;
        this.inputValidator = new InputValidator();
    }

    public void start(LocalDate currentDate) {
        inputView.printStartMessage();
        for (int i = 0; i < 6; i++) {
            roundNumber++;
            Word userInputWord = getUserInputWord();
            Answer answerWord = getAnswerWord(currentDate);
            Result result = answerWord.compare(userInputWord);
            results.add(result);
            if (isCorrect()) {
                break;
            }
        }
    }

    private Answer getAnswerWord(LocalDate currentDate) {
        String answerString = answerGenerator.getAnswer(currentDate);
        return Answer.from(answerString);
    }

    private Word getUserInputWord() {
        inputView.printInputMessage();
        String inputString = inputView.getUserInput();
        inputValidator.validateInFile(inputString);
        return Word.from(inputString);
    }

    private boolean isCorrect() {
        if (results.hasCorrect()) {
            outputView.printRount(roundNumber);
            outputView.print(results);
            return true;
        }
        outputView.print(results);
        return false;
    }

}
