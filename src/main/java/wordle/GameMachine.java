package wordle;

import wordle.view.GameView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class GameMachine {
    // TODO
//    private final List<String> words;
//
//    GameMachine() {
//        words = words();
//    }
//
//    //목표: words.txt 에서 정답을 하나 불러온다.
//    public String findQuestion() {
//        int index = calcGetQuestionIndex(words.size());
//        return words.get(index);
//    }
//
//    public boolean checkAnswer(Word userInputAnswer) {
//        return words.contains(userInputAnswer.castWordsToString());
//    }

    private int calcGetQuestionIndex(int wordsTxtSize) {
        long todayToEpochDay = LocalDate.now().toEpochDay();
        long standardDateToEpochDay = LocalDate.of(2021, Month.JUNE, 19).toEpochDay();

        return (int) ((todayToEpochDay - standardDateToEpochDay) % wordsTxtSize);
    }

    public static List<Result> compare(String question, String answer) {
        String[] questionStrings = question.split("");

        String[] answerStrings = answer.split("");

        List<Result> results = new ArrayList<>();

        for (int i = 0; i < questionStrings.length; i++) {
            if (questionStrings[i].equals(answerStrings[i])) {
                results.add(Result.정답);
            } else if (answer.contains(questionStrings[i])) {
                results.add(Result.문자만_같음);
            } else {
                results.add(Result.틀림);
            }
        }

        return results;
    }

    public void start() {
        FileReader fileReader = new FileReader(); // TODO: 이름
        List<String> questions = fileReader.readAll("words.txt");
        // TODO: select qustion, validate

        GameView gameView = new GameView();
        gameView.initialize();
        gameView.inputAnswer();

        String inputData = getUserInput();
        // validate inputData
        // TODO: new Word(inputDate);

        // 입력과 정답을 비교하는 부분
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
}
