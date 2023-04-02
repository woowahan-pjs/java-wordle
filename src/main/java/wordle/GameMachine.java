package wordle;

import wordle.domain.*;
import wordle.util.FileReader;
import wordle.util.InputReader;
import wordle.view.GameView;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class GameMachine {

    public void start() {
        FileReader fileReader = new FileReader(); // TODO: 이름
        List<String> questions = fileReader.readAll("words.txt");

        GameView gameView = new GameView();
        gameView.initialize();

        Worker worker = new Worker(transToWords(questions));
        Word question = worker.proposeQuestion();

        Round round = new Round();
        GameRecords gameRecords = new GameRecords();
        while (!round.isFinal()) {
            gameView.inputAnswer();

            InputReader inputReader = new InputReader();
            String inputData = inputReader.getUserInput();
            Word inputWord = new Word(inputData);
            List<Result> results = question.compare(inputWord);
            gameRecords.add(new GameRecord(results));
            gameView.printRecords(gameRecords); // print game record

            round.next();
        }
    }

    private List<Word> transToWords(List<String> words) {
        return words.stream()
            .map(Word::new)
            .collect(toList())
            ;
    }
}
