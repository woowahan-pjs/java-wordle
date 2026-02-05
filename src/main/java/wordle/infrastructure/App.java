package wordle.infrastructure;

import wordle.application.GameService;
import wordle.application.OutputPort;
import wordle.domain.game.Game;
import wordle.domain.game.GameResult;
import wordle.domain.word.Answer;
import wordle.domain.word.AnswerSelector;
import wordle.domain.word.Word;
import wordle.domain.word.WordRepository;
import wordle.infrastructure.persistence.FileWordRepository;
import wordle.infrastructure.ui.ConsoleUI;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        WordRepository wordRepository = new FileWordRepository();
        OutputPort outputPort = new ConsoleUI();

        System.out.println(outputPort.makeWelcomeText());

        GameResult gameResult = new GameResult();
        Game wordleGame = new Game(gameResult);
        AnswerSelector answerSelector = new AnswerSelector(wordRepository);
        String selectedAnswer = answerSelector.pickAnswer();
        Answer answer = new Answer(selectedAnswer);

        Word word = new Word(answer, wordRepository);
        GameService gameService = new GameService(word, wordleGame, gameResult, outputPort);

        try (Scanner scanner = new Scanner(System.in)) {
            while (!wordleGame.isFinished()) {
                System.out.println(outputPort.makeInputInfoText());
                String userInput = scanner.next();

                String statusMessage = gameService.run(userInput);
                if (!statusMessage.isEmpty()) {
                    System.out.println(statusMessage);
                }
            }
        }

    }

}
