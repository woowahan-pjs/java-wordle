package infrastructure;

import application.port.OutputPort;
import application.service.Client;
import domain.model.Answer;
import domain.model.Input;
import domain.model.Result;
import domain.model.Word;
import domain.port.WordRepository;
import domain.service.AnswerSelector;
import domain.service.Game;
import infrastructure.adapter.in.ConsoleOutputAdapter;
import infrastructure.adapter.out.FileWordRepository;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        WordRepository wordRepository = new FileWordRepository();
        OutputPort outputPort = new ConsoleOutputAdapter();

        System.out.println(outputPort.getWelcomeMessage());

        Result result = new Result();
        Game game = new Game(result, outputPort);
        AnswerSelector answerSelector = new AnswerSelector(wordRepository);
        String selectedAnswer = answerSelector.selectAnswer();
        Answer answer = new Answer(selectedAnswer);

        try (Scanner scanner = new Scanner(System.in)) {
            while (!game.isFinished()) {
                System.out.println(outputPort.getInputInfoMessage());
                String userInput = scanner.next();
                Word word = new Word(new Input(userInput, result), answer, wordRepository, outputPort);

                Client client = new Client(word, game, result, outputPort);
                String gameResult = client.run();

                System.out.println(gameResult);
            }
        }

    }

}
