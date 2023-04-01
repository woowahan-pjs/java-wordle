package wordle;

import wordle.domain.Result;
import wordle.domain.Word;
import wordle.domain.Worker;
import wordle.util.FileReader;
import wordle.view.GameView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class GameMachine {

    public void start() {
        FileReader fileReader = new FileReader(); // TODO: 이름
        List<String> questions = fileReader.readAll("words.txt");
        // TODO: select qustion, validate

        GameView gameView = new GameView();
        gameView.initialize();
        gameView.inputAnswer();

        String inputData = getUserInput();
        Word inputWord = new Word(inputData);
        Worker worker = new Worker(transToWords(questions));
        Word question = worker.proposeQuestion();
        // 입력과 정답을 비교하는 부분
        List<Result> results = question.compare(inputWord);
        // 결과 출력



//        List<Result> results = GameMachine.compare(question, answer);
    }

    // TODO: inputUtil ?
    private String getUserInput() {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e); // TODO: change
        }
    }

    private List<Word> transToWords(List<String> words) {
        return words.stream()
            .map(Word::new)
            .collect(toList())
            ;
    }
}
