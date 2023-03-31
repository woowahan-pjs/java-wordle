package wordle;

import wordle.view.GameView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 동작하는 코드 만들기
        // user input

        String inputData = null;

        GameMachine gameMachine = new GameMachine();
        GameView gameView = new GameView();

        String question = gameMachine.findQuestion();

        gameView.initialize();
        gameView.inputAnswer();


        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            inputData = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }


        // 사용자로부터 입력 받는부분
        // 입력을 검증하는부분

        // 입력과 정답을 비교하는 부분
        // 결과 출력

        // 사용자로부터 입력 받기
        // String str = getUserInput();
        question = "asdfg";
        String answer = "azxgv";  // 사용자의 입력 값

        List<Result> results = GameMachine.compare(question, answer);
    }

}
